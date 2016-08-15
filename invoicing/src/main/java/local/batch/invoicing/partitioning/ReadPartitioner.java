package local.batch.invoicing.partitioning;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;
import javax.inject.Named;
import java.util.Properties;

/**
 * Created by Dmitry Alexandrov on 29.07.16.
 */
@Named
public class ReadPartitioner implements PartitionMapper {

    @Override
    public PartitionPlan mapPartitions() throws Exception {
        return new PartitionPlanImpl() {

            @Override
            public int getPartitions() {
                return 2;
            }

            @Override
            public int getThreads() {
                return 2;
            }

            @Override
            public Properties[] getPartitionProperties() {
                Properties[] props = new Properties[getPartitions()];

                for (int i = 0; i < getPartitions(); i++) {
                    props[i] = new Properties();
                    props[i].setProperty("start", String.valueOf(i * 500));
                    props[i].setProperty("end", String.valueOf((i + 1) * 500));
                }
                return props;
            }
        };
    }
}