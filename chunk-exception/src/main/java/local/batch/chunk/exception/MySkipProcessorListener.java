package local.batch.chunk.exception;

import javax.batch.api.chunk.listener.SkipProcessListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MySkipProcessorListener implements SkipProcessListener {
    @Override
    public void onSkipProcessItem(Object t, Exception e) throws Exception {
        ChunkExceptionRecorder.chunkExceptionsCountDownLatch.countDown();
        System.out.println("MySkipProcessorListener.onSkipProcessItem: " + ((MyInputRecord) t).getId() + ", " + e.getMessage());
    }
}
