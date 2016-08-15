package local.batch.chunk.twitter.extract;

import twitter4j.Status;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class TwitterProcessor implements ItemProcessor {

    @Override
    public TwitRecord processItem(Object t) {
        Status st = (Status)t;
        return new TwitRecord(st.getCreatedAt(),st.getText());
    }
}