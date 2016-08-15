package local.batch.chunk.twitter.analyse;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class AnalyseReader extends AbstractItemReader {

    private BufferedReader br;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        String fileName = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        br = new BufferedReader(new FileReader("/Users/mitia/Desktop/item/" + fileName + ".txt"));
    }

    @Override
    public String readItem() throws IOException {
        return br.readLine();
    }
}