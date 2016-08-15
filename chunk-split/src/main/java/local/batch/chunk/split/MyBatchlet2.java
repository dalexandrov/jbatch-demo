package local.batch.chunk.split;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;
import java.util.Random;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyBatchlet2 extends AbstractBatchlet {

    @Override
    public String process() throws InterruptedException {
        int executionTime = new Random().nextInt(1000);
        Thread.sleep(executionTime);
        System.out.println("Running inside a batchlet 2 for: "+executionTime);

        return "COMPLETED";
    }

}
