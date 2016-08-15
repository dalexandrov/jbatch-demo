package local.batch.chunk.csv.database.scheduler;

import local.batch.util.BatchTestHelper;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmitry Alexandrov on 01.08.16.
 */
@Startup
@Singleton
public class InvoiceScheduler {
    public static CountDownLatch timerScheduleCountDownLatch = new CountDownLatch(2);

    @Schedule(hour = "*", minute = "*", second = "*/15")
    public void mySheduledJob() throws Exception{
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Long executionId = jobOperator.start("invoicing", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);

        jobExecution = BatchTestHelper.keepTestAlive(jobExecution);

        timerScheduleCountDownLatch.countDown();
        System.out.println("<<<JOB DONE>>>: "+timerScheduleCountDownLatch.getCount());
    }

}
