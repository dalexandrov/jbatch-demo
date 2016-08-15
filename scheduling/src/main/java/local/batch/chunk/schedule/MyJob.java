package local.batch.chunk.schedule;

import javax.batch.runtime.BatchRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class MyJob implements Runnable {
    public static List<Long> executedBatchs = new ArrayList<>();

    public void run() {
        executedBatchs.add(BatchRuntime.getJobOperator().start("myJob", new Properties()));
        afterRun();
    }

    protected void afterRun() {
    }
}
