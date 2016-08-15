package local.batch.invoicing.processing;

import local.batch.invoicing.Person;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Dmitry Alexandrov on 28.07.16.
 */
@Named
public class InvoiceItemReader extends AbstractItemReader {

    @PersistenceContext
    private EntityManager em;

    private Iterator<Invoice> invoiceIterator;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        invoiceIterator = em.createNamedQuery("Invoice.findAll").getResultList().iterator();
    }

    @Override
    public Invoice readItem() {
        if (invoiceIterator.hasNext())
            return invoiceIterator.next();
        return null;
    }
}
