package local.batch.chunk.exception;

import javax.batch.api.chunk.listener.RetryProcessListener;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyRetryProcessorListener implements RetryProcessListener {
    @Override
    public void onRetryProcessException(Object item, Exception ex) throws Exception {
        System.out.println("MyRetryProcessorListener.onRetryProcessException");
    }
}
