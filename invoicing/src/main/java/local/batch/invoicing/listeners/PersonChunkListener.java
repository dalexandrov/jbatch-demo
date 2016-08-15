package local.batch.invoicing.listeners;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by Dmitry Alexandrov on 28.07.16.
 */
@Named
public class PersonChunkListener extends AbstractChunkListener {

    @Override
    public void beforeChunk() throws Exception {
        Logger.getLogger(getClass().getName()).info("starting new chunk");
    }

    @Override
    public void afterChunk() throws Exception {
        Logger.getLogger(getClass().getName()).info("just ended a chunk");
    }
}