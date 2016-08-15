package local.batch.invoicing.processing;

import local.batch.invoicing.Person;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class InvoiceEmailer extends AbstractItemWriter {


    @Override
    public void writeItems(List list) {
        list.parallelStream().forEach(e->System.out.println("Emailing: "+((Invoice)e).getEmail()));
    }
}