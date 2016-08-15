package local.batch.chunk.schedule;

import local.batch.chunk.schedule.MyBatchlet;
import local.batch.chunk.schedule.MyJob;
import local.batch.chunk.schedule.MyManagedScheduledBatch;
import local.batch.chunk.schedule.MyManagedScheduledBatchBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.beans10.BeansDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@RunWith(Arquillian.class)
public class ManagedScheduledBatchTest {
    @Inject
    private MyManagedScheduledBatch managedScheduledBatch;


    @Deployment
    public static WebArchive createDeployment() {
        BeansDescriptor beansXml = Descriptors.create(BeansDescriptor.class);

        WebArchive war = ShrinkWrap.create(WebArchive.class)
            .addClasses(
                MyBatchlet.class,
                MyJob.class,
                MyJobAlternative.class,
                MyManagedScheduledBatch.class,
                MyManagedScheduledBatchBean.class,
                MyManagedScheduledBatchAlternative.class)
            .addAsWebInfResource(
                new StringAsset(beansXml.createAlternatives().clazz(
                    MyManagedScheduledBatchAlternative.class.getName()).up().exportAsString()),
                beansXml.getDescriptorName())
            .addAsResource("META-INF/batch-jobs/myJob.xml");
        System.out.println(war.toString(true));
        return war;
    }


    @Test
    public void testTimeScheduleBatch() throws Exception {
        managedScheduledBatch.runJob();

        MyJobAlternative.managedScheduledCountDownLatch.await(90, TimeUnit.SECONDS);

        assertEquals(0, MyJobAlternative.managedScheduledCountDownLatch.getCount());
        assertEquals(3, MyJob.executedBatchs.size());

        for (Long executedBatch : MyJob.executedBatchs) {
            assertEquals(BatchStatus.COMPLETED,
                BatchRuntime.getJobOperator().getJobExecution(executedBatch).getBatchStatus());
        }
    }
}
