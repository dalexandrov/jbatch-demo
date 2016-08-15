package local.batch.chunk.twitter.analyse;

import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class LikeAnalyseWriter extends AbstractAnalyseWriter {

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("Analizes: likes");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Finished analyze!");
        System.out.println("Likes: "+counter);
    }
}