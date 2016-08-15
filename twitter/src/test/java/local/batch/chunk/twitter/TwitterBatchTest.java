package local.batch.chunk.twitter;

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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
public class TwitterBatchTest {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(BatchTestHelper.class)
            .addPackage("local.batch.chunk.twitter.extract")
            .addPackage("local.batch.chunk.twitter.analyse")
            .addPackage("twitter4j")
            .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
            .addAsResource("META-INF/batch-jobs/twitterJob.xml");
        System.out.println(war.toString(true));
        return war;
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testBatchTwitterJob() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Long executionId = jobOperator.start("twitterJob", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);

        jobExecution = BatchTestHelper.keepTestAlive(jobExecution);

        assertEquals(jobExecution.getBatchStatus(), BatchStatus.COMPLETED);
    }
}
