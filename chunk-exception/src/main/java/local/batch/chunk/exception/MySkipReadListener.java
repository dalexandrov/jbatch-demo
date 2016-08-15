package local.batch.chunk.exception;

import javax.batch.api.chunk.listener.SkipReadListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MySkipReadListener implements SkipReadListener {
    @Override
    public void onSkipReadItem(Exception e) throws Exception {
        ChunkExceptionRecorder.chunkExceptionsCountDownLatch.countDown();
        System.out.println("MySkipReadListener.onSkipReadItem: " + e.getMessage());
    }
}
