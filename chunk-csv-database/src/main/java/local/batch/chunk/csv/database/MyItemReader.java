package local.batch.chunk.csv.database;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemReader extends AbstractItemReader {

    private BufferedReader reader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        reader = new BufferedReader(
                new InputStreamReader(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("/META-INF/mydata.csv")));
    }

    @Override
    public String readItem() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(MyItemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}