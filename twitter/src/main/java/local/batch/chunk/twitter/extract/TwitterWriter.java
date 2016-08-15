package local.batch.chunk.twitter.extract;

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
public class TwitterWriter extends AbstractItemWriter {

    private FileOutputStream fos;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        String fileName = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        fos = new FileOutputStream("/Users/mitia/Desktop/item/" + fileName + ".txt");
    }

    @Override
    public void writeItems(List list) throws Exception {
        List<String> lines = ((List<TwitRecord>) list).stream().map(e -> e.getDate() + ";" + e.getMessage()).collect(Collectors.toList());
        for (String line : lines) {
            fos.write(line.concat("\n").getBytes());
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Finished extraction!");
        fos.close();
    }
}