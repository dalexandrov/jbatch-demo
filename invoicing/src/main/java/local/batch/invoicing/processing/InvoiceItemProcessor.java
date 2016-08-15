package local.batch.invoicing.processing;

import local.batch.invoicing.Person;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by Dmitry Alexandrov on 28.07.16.
 */
@Named
public class InvoiceItemProcessor  implements ItemProcessor{
    private static int id = 1;

    @Override
    public Object processItem(Object o) {
        return new Invoice(id++,((Person)o).getId(),((Person)o).getEmail(),"PDF".getBytes());
    }
}
