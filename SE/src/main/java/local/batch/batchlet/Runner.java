package local.batch.batchlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import java.util.Properties;

/**
 * Created by Dmitry Alexandrov on 31.07.16.
 */
public class Runner {
    public static void main(String[] args) throws Exception{
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Long executionId = jobOperator.start("myJob", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);

        // <1> Job should be completed.
        System.out.println("-> "+jobExecution.getBatchStatus());
        Thread.sleep(5000);

    }
}
