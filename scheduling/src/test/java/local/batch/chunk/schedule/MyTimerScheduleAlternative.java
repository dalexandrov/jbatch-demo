package local.batch.chunk.schedule;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Startup
@Singleton
public class MyTimerScheduleAlternative extends AbstractTimerBatch {
    public static CountDownLatch timerScheduleCountDownLatch = new CountDownLatch(3);

    @Override
    @Schedule(hour = "*", minute = "*", second = "*/15")
    public void myJob() {
        super.myJob();
    }

    @Override
    protected void afterRun() {
        timerScheduleCountDownLatch.countDown();
    }
}
