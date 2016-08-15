package local.batch.chunk.schedule;

import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public abstract class AbstractTimerBatch {
    public static List<Long> executedBatchs = new ArrayList<>();

    @Schedule(hour = "*", minute = "0", second = "0")
    public void myJob() {
        executedBatchs.add(BatchRuntime.getJobOperator().start("myJob", new Properties()));
        afterRun();
    }

    protected void afterRun() {
    }
}
