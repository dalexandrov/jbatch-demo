package local.batch.chunk.csv.database.scheduler;

import local.batch.invoicing.Person;
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
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


//@RunWith(Arquillian.class)
public class InvoicingScheduledTest {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Inject
//    private InvoiceScheduler invoiceScheduler;
//
//    @Deployment
//    public static WebArchive createDeployment() {
//        WebArchive war = ShrinkWrap.create(WebArchive.class)
//                .addClass(BatchTestHelper.class)
//                .addPackage("local.batch.invoicing")
//                .addPackage("local.batch.invoicing.listeners")
//                .addPackage("local.batch.invoicing.processing")
//                .addPackage("local.batch.invoicing.partitioning")
//                .addClass(InvoiceScheduler.class)
//                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
//                .addAsResource("META-INF/batch-jobs/invoicing.xml")
//                .addAsResource("META-INF/persistence.xml")
//                .addAsResource("META-INF/create.sql")
//                .addAsResource("META-INF/drop.sql")
//                .addAsResource("META-INF/MOCK_DATA.csv");
//        System.out.println(war.toString(true));
//        return war;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Test
//    public void testPersons() throws Exception {
//
//        InvoiceScheduler.timerScheduleCountDownLatch.await(90, TimeUnit.SECONDS);
//
//        invoiceScheduler.mySheduledJob();
//    }
}
