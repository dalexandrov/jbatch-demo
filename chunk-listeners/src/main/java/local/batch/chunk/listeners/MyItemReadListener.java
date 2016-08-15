package local.batch.chunk.listeners;

import javax.batch.api.chunk.listener.AbstractItemReadListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemReadListener extends AbstractItemReadListener {

    @Override
    public void beforeRead() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemReadListener.beforeRead");
    }

    @Override
    public void afterRead(Object item) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemReadListener.afterRead: " + item);
    }

    @Override
    public void onReadError(Exception ex) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemReadListener.onReadError: " + ex.getLocalizedMessage());
    }
}
