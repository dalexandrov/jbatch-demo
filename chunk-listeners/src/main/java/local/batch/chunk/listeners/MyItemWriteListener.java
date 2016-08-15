package local.batch.chunk.listeners;

import java.util.List;
import javax.batch.api.chunk.listener.AbstractItemWriteListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemWriteListener extends AbstractItemWriteListener {

    @Override
    public void beforeWrite(List items) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemWriteListener.beforeWrite: " + items);
    }

    @Override
    public void afterWrite(List items) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemWriteListener.afterWrite: " + items);
    }

    @Override
    public void onWriteError(List items, Exception ex) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemWriteListener.onError: " + items + ", " + ex.getLocalizedMessage());
    }
}
