package local.batch.chunk.listeners;

import javax.batch.api.listener.AbstractStepListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyStepListener extends AbstractStepListener {

    @Override
    public void beforeStep() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyStepListener.beforeStep");
    }

    @Override
    public void afterStep() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyStepListener.afterStep");
    }
}
