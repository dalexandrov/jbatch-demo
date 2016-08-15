package local.batch.invoicing;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import java.lang.instrument.IllegalClassFormatException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class PersonItemProcessor implements ItemProcessor {

    private static AtomicInteger id = new AtomicInteger(1);

    @Override
    public Person processItem(Object t) throws Exception{
        StringTokenizer tokens = new StringTokenizer((String) t, ",");

        String firstName = tokens.nextToken();
        String lastName = tokens.nextToken();
        String email = tokens.nextToken();
        String phone = tokens.nextToken();
        String country = tokens.nextToken();
        String address = tokens.nextToken();
        String card = tokens.nextToken();

        if (firstName.equals("111")){
//            throw new UnsupportedOperationException("exception");
        }

        return new Person(id.incrementAndGet(),firstName,lastName,email,phone,country,address,card);
    }
}