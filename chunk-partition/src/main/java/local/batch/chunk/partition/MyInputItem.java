package local.batch.chunk.partition;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class MyInputItem {
    private int value;

    public MyInputItem() {
    }

    public MyInputItem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "local.batch.chunk.partition.MyInputItem: " + value;
    }
}
