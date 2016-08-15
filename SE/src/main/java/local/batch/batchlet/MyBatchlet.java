package local.batch.batchlet;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyBatchlet extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("<<<<<<<Running inside a batchlet>>>>>>>>");

        return BatchStatus.COMPLETED.toString();
    }
}
