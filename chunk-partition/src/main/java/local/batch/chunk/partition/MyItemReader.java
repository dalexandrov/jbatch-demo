package local.batch.chunk.partition;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemReader extends AbstractItemReader {

    public static int totalReaders = 0;
    private int readerId;

    private StringTokenizer tokens;

    @Inject
    @BatchProperty(name = "start")
    private String startProp;

    @Inject
    @BatchProperty(name = "end")
    private String endProp;

    @Override
    public void open(Serializable e) {
        int start = new Integer(startProp);
        int end = new Integer(endProp);
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            builder.append(i);
            if (i < end)
                builder.append(",");
        }

        readerId = ++totalReaders;
        tokens = new StringTokenizer(builder.toString(), ",");
    }

    @Override
    public MyInputItem readItem() {
        if (tokens.hasMoreTokens()) {
            int token = Integer.valueOf(tokens.nextToken());
            System.out.format("readItem (%d): %d\n", readerId, token);
            return new MyInputItem(token);
        }
        return null;
    }
}