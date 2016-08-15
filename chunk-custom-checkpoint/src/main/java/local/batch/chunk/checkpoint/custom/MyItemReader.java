package local.batch.chunk.checkpoint.custom;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemReader extends AbstractItemReader {

    private StringTokenizer tokens;
    static int COUNT = 0;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        tokens = new StringTokenizer("1,2,3,4,5,6,7,8,9,10", ",");
    }

    @Override
    public MyInputItem readItem() {
        if (tokens.hasMoreTokens()) {
            COUNT++;
            return new MyInputItem(Integer.valueOf(tokens.nextToken()));
        }
        return null;
    }
}
