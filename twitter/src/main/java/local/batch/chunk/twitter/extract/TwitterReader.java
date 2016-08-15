package local.batch.chunk.twitter.extract;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class TwitterReader extends AbstractItemReader {

    private Iterator<Status> twitIterator;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("dpIGUFzd8QgWblROpjm3XG8Y8")
                .setOAuthConsumerSecret("VzDyeoiBBglfknC0RBVwlvRfGCIHDCblwD9bivmbyJXLCTkw6V")
                .setOAuthAccessToken("361985635-t9d1fIDsmI6Ub2XV1VJE5sD7LyRHHzn6n8Z5RQsu")
                .setOAuthAccessTokenSecret("6i8ZzkgvUJs7pY7QGBKsFiRrlCweed2Q98L7VUwDcbmPp");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Query query = new Query("JustinBieber");
        query.count(Integer.MAX_VALUE);
        query.setSince("2016-06-12");
        query.setUntil("2016-07-13");
        QueryResult result = twitter.search(query);
        twitIterator = result.getTweets().iterator();
        System.out.println("Opened: "+result.getTweets().size());
    }

    @Override
    public Status readItem() {
        if (twitIterator.hasNext()) {
            return twitIterator.next();
        }
        return null;
    }
}