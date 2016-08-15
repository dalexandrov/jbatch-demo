package local.batch.chunk.partition;

import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemProcessor implements ItemProcessor {
    public static int totalProcessors = 0;
    private int processorId;

    @Inject
    JobContext context;

    public MyItemProcessor() {
        processorId = ++totalProcessors;
    }

    @Override
    public MyOutputItem processItem(Object t) {
        System.out.format("processItem (%d): %s\n", processorId, t);

        return (((MyInputItem) t).getValue() % 2 == 0) ? null : new MyOutputItem(((MyInputItem) t).getValue() * 2);
    }
}