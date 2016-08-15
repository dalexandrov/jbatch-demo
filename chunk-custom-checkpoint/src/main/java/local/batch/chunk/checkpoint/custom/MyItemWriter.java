package local.batch.chunk.checkpoint.custom;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List list) throws Exception {
        System.out.println(list);
    }
}
