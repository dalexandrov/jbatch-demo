package local.batch.chunk.schedule;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
@Alternative
@Stateless
@Local(MyManagedScheduledBatch.class)
public class MyManagedScheduledBatchAlternative extends MyManagedScheduledBatchBean {
    @Override
    protected MyJob createJob() {
        return new MyJobAlternative();
    }
}
