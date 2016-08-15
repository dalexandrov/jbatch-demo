package local.batch.chunk.listeners;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List list) {
        System.out.println("writeItems: " + list);
    }
}
