package local.batch.chunk.listeners;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class BatchListenerRecorder {
    public static CountDownLatch batchListenersCountDownLatch = new CountDownLatch(60);
}
