package local.batch.chunk.schedule;

import local.batch.chunk.schedule.MyJob;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class MyJobAlternative extends MyJob {
    public static CountDownLatch managedScheduledCountDownLatch = new CountDownLatch(3);

    @Override
    protected void afterRun() {
        managedScheduledCountDownLatch.countDown();
    }
}
