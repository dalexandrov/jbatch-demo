package local.batch.chunk.csv.database;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemProcessor implements ItemProcessor {
    private static int id = 1;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

    @Override
    public Person processItem(Object t) {
        System.out.println("processItem: " + t);

        StringTokenizer tokens = new StringTokenizer((String) t, ",");

        String name = tokens.nextToken();
        String date;

        try {
            date = tokens.nextToken();
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            return null;
        }

        String phone = tokens.nextToken();

        String email = tokens.nextToken();

        return new Person(id++, name, date,phone,email);
    }
}