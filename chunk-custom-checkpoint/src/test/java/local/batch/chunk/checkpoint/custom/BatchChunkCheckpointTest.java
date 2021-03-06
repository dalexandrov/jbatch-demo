package local.batch.chunk.checkpoint.custom;

import local.batch.chunk.checkpoint.custom.MyCheckpointAlgorithm;
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
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Arquillian.class)
public class BatchChunkCheckpointTest {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(BatchTestHelper.class)
                .addPackage("local.batch.chunk.checkpoint.custom")
                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsResource("META-INF/batch-jobs/myJob.xml");
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void testBatchChunkCheckpoint() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Long executionId = jobOperator.start("myJob", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);

        jobExecution = BatchTestHelper.keepTestAlive(jobExecution);

        List<StepExecution> stepExecutions = jobOperator.getStepExecutions(executionId);
        for (StepExecution stepExecution : stepExecutions) {
            if (stepExecution.getStepName().equals("myStep")) {
                Map<Metric.MetricType, Long> metricsMap = BatchTestHelper.getMetricsMap(stepExecution.getMetrics());

                assertEquals(10L, metricsMap.get(Metric.MetricType.READ_COUNT).longValue());
                assertEquals(10L, metricsMap.get(Metric.MetricType.WRITE_COUNT).longValue());
                assertEquals(10L / 5L + 1, metricsMap.get(Metric.MetricType.COMMIT_COUNT).longValue());
            }
        }

        assertTrue(MyCheckpointAlgorithm.checkpointCountDownLatch.await(0, TimeUnit.SECONDS));
        assertEquals(jobExecution.getBatchStatus(), BatchStatus.COMPLETED);
    }
}
