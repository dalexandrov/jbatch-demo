package local.batch.chunk.listeners;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyChunkListener extends AbstractChunkListener {

    @Override
    public void beforeChunk() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyChunkListener.beforeChunk");
    }

    @Override
    public void afterChunk() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyChunkListener.afterChunk");
    }
}
