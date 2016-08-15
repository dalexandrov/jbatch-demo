package local.batch.chunk.listeners;

import java.util.StringTokenizer;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Named
public class MyItemReader extends AbstractItemReader {

    private final StringTokenizer tokens;

    public MyItemReader() {
        tokens = new StringTokenizer("1,2,3,4,5,6,7,8,9,10", ",");
    }

    @Override
    public MyInputItem readItem() {
        if (tokens.hasMoreTokens()) {
            return new MyInputItem(Integer.valueOf(tokens.nextToken()));
        }
        return null;
    }
}
