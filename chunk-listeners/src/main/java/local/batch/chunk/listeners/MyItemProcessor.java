package local.batch.chunk.listeners;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object t) {
        System.out.println("processItem: " + t);

        return new MyOutputItem(((MyInputItem) t).getId() * 2);
    }
}
