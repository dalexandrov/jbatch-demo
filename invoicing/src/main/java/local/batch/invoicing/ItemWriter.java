package local.batch.invoicing;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
@Named
public class ItemWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;

    @Override
    public void writeItems(List list) {
        System.out.println("writeItems: " + list);
        for (Object item : list) {
            em.persist(item);
        }
    }
}