package local.batch.invoicing.listeners;

import javax.batch.api.listener.AbstractJobListener;
import javax.inject.Named;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class PersonJobListener extends AbstractJobListener {

    @Override
    public void beforeJob() {
        Logger.getLogger(getClass().getName()).info("Started job on "+new Date());
    }

    @Override
    public void afterJob() {
        Logger.getLogger(getClass().getName()).info("Finished job on "+new Date());
    }
}
