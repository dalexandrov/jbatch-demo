package local.batch.chunk.exception;

import javax.batch.api.chunk.listener.RetryWriteListener;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyRetryWriteListener implements RetryWriteListener {
    @Override
    public void onRetryWriteException(List<Object> items, Exception ex) throws Exception {
        System.out.println("MyRetryWriteListener.onRetryWriteException");
    }
}
