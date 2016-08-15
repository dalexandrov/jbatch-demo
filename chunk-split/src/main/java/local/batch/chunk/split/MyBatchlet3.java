package local.batch.chunk.split;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyBatchlet3 extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet 3");

        return "COMPLETED";
    }

}
