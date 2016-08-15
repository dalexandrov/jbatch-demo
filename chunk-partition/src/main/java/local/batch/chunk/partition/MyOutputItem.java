package local.batch.chunk.partition;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
 */
public class MyOutputItem {
    private int value;

    public MyOutputItem() {
    }

    public MyOutputItem(int value) {
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
        return "MyOutputItem: " + value;
    }
}
