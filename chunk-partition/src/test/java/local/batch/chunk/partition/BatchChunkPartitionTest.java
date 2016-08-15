package local.batch.chunk.partition;

import local.batch.util.BatchTestHelper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;


/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@RunWith(Arquillian.class)
public class BatchChunkPartitionTest {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(BatchTestHelper.class)
                .addPackage("local.batch.chunk.partition")
                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsResource("META-INF/batch-jobs/myJob.xml");
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void testBatchChunkPartition() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Long executionId = jobOperator.start("myJob", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);

        jobExecution = BatchTestHelper.keepTestAlive(jobExecution);

        List<StepExecution> stepExecutions = jobOperator.getStepExecutions(executionId);
        for (StepExecution stepExecution : stepExecutions) {
            if (stepExecution.getStepName().equals("myStep")) {
                Map<Metric.MetricType, Long> metricsMap = BatchTestHelper.getMetricsMap(stepExecution.getMetrics());

                // The read count should be 20 elements.
                assertEquals(20L, metricsMap.get(Metric.MetricType.READ_COUNT).longValue());
                // The write count should be 10. Only half of the elements read are processed to be written.
                assertEquals(10L, metricsMap.get(Metric.MetricType.WRITE_COUNT).longValue());
                // Number of elements by the item count value on myJob.xml, plus an additional transaction for the
                // remaining elements by each partition.
                long commitCount = (10L / 3 + (10 % 3 > 0 ? 1 : 0)) * 2;
                // The commit count should be 8. Checkpoint is on every 3rd read, 4 commits for read elements and 2 partitions.
                assertEquals(commitCount, metricsMap.get(Metric.MetricType.COMMIT_COUNT).longValue());
            }
        }

        // <4> Job should be completed.
        assertEquals(BatchStatus.COMPLETED, jobExecution.getBatchStatus());
    }
}
