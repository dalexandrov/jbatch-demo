package local.batch.chunk.twitter.analyse;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class HateAnalyseWriter extends AbstractAnalyseWriter {

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("Analizes: hates");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Finished analyze!");
        System.out.println("Hates: "+counter);
    }
}