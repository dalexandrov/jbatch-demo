package local.batch.chunk.listeners;

import javax.batch.api.listener.AbstractJobListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyJobListener extends AbstractJobListener {

    @Override
    public void beforeJob() {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyJobListener.beforeJob");
    }

    @Override
    public void afterJob() {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyJobListener.afterJob");
    }
}
