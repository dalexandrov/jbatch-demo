package local.batch.chunk.exception;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object t) {
        System.out.println("MyItemProcessor.processItem: " + t);

        if (((MyInputRecord) t).getId() == 6) {
            throw new NullPointerException();
        }

        return new MyOutputRecord(((MyInputRecord) t).getId());
    }
}
