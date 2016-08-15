package local.batch.invoicing.processing;

import local.batch.invoicing.Person;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class PersonDBItemReader extends AbstractItemReader {

    @PersistenceContext
    private EntityManager em;

    private Iterator<Person> personIterator;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        personIterator = em.createNamedQuery("Person.findAll").getResultList().iterator();
    }

    @Override
    public Person readItem() {
        if (personIterator.hasNext())
            return personIterator.next();
        return null;
    }
}