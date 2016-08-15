package local.batch.chunk.twitter.analyse;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class AbstractAnalyseWriter extends AbstractItemWriter {

    protected int counter;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("Analizes: hates");
    }

    @Override
    public void writeItems(List list) throws Exception {
        counter += ((List<Boolean>)list).stream().filter(e->e.booleanValue()==true).count();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Finished analise!");
        System.out.println("Likes: "+counter);
    }
}