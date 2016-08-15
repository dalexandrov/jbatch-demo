package local.batch.chunk.checkpoint.custom;

import javax.batch.api.chunk.AbstractCheckpointAlgorithm;
import javax.inject.Named;
import java.util.concurrent.CountDownLatch;
/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyCheckpointAlgorithm extends AbstractCheckpointAlgorithm {
    public static CountDownLatch checkpointCountDownLatch = new CountDownLatch(10);

    @Override
    public boolean isReadyToCheckpoint() throws Exception {
        checkpointCountDownLatch.countDown();
        return MyItemReader.COUNT % 5 == 0;
    }
}
