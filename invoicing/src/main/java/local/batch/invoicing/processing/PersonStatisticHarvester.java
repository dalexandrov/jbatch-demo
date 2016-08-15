package local.batch.invoicing.processing;

import local.batch.invoicing.Person;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitry Alexandrov on 28.07.16.
 */
@Named
public class PersonStatisticHarvester extends AbstractItemWriter {

    private static final Map<String,Integer> statistics= new HashMap<>();

    @Override
    public void writeItems(List list) {
        ((List<Person>)list).stream()
                .map(e->e.getCountry())
                .map(e-> {if(!statistics.containsKey(e))statistics.put(e,0);return e;})
                .forEach(e->statistics.compute(e,(k,v)->v+1));
    }

    @Override
    public void close(){
        System.out.println("<--------------------------------------------------------------------->");
        System.out.println(statistics);
        System.out.println("<--------------------------------------------------------------------->");
    }
}
