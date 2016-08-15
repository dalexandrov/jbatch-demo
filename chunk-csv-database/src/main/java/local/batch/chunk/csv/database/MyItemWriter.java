package local.batch.chunk.csv.database;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class MyItemWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;

    @Override
    public void writeItems(List list) {
        System.out.println("writeItems: " + list);
        for (Object person : list) {
            em.persist(person);
        }
    }
}