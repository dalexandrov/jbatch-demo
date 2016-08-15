package local.batch.chunk.exception;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class ChunkExceptionRecorder {
    public static CountDownLatch chunkExceptionsCountDownLatch = new CountDownLatch(3);
    public static int retryReadExecutions = 0;
}
