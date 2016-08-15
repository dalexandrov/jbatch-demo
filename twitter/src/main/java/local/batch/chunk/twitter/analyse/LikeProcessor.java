package local.batch.chunk.twitter.analyse;

import twitter4j.Status;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class LikeProcessor implements ItemProcessor {

    @Override
    public Boolean processItem(Object t) {
        String line = (String)t;
        return line.toLowerCase().contains("love");
    }
}