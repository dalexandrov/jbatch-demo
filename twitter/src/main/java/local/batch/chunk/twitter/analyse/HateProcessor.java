package local.batch.chunk.twitter.analyse;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class HateProcessor implements ItemProcessor {

    @Override
    public Boolean processItem(Object t) {
        String line = (String)t;
        return line.toLowerCase().contains("like");
    }
}