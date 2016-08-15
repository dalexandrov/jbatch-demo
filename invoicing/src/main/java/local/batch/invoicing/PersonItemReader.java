package local.batch.invoicing;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
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
public class PersonItemReader extends AbstractItemReader {

    private BufferedReader reader;

    public static int totalReaders = 0;
    private int readerId = 0;

    @Inject
    @BatchProperty(name = "start")
    private String startProp;

    @Inject
    @BatchProperty(name = "end")
    private String endProp;

    @Inject
    private JobContext context;

    private int end = 0;

    private int counter = 0;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        readerId = ++totalReaders;

        int start = new Integer(startProp);
        end = new Integer(endProp);

        Logger.getLogger(getClass().getName()).info("Reader " + readerId + " start: " + startProp + " end:" + endProp);

        reader = new BufferedReader(
                new InputStreamReader(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("/META-INF/MOCK_DATA.csv")));

        //start from checkpoint
        if (checkpoint != null) {
            System.out.println("Skipping already read elements: "+checkpoint);
        }
        int checkpointStart = (Integer) checkpoint == null ? 0 : ((Integer) checkpoint).intValue();
        for (counter = checkpointStart; counter < start; counter++) reader.readLine();
    }

    @Override
    public String readItem() {
        try {
            if (counter >= end) return null;
            counter++;
            return reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(PersonItemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        // This is used internally by batch to stop the retry. Remember to implement equals on the read elements.
        return counter;
    }
}
