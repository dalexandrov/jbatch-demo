package local.batch.chunk.checkpoint.custom;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemProcessor implements ItemProcessor {

    @Override
    public MyOutputItem processItem(Object t) {
        System.out.println("processItem: " + t);

        return new MyOutputItem(((MyInputItem) t).getValue() * 2);
    }
}
