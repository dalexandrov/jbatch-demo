package local.batch.chunk.checkpoint.custom;

/**
 * Created by Dmitry Alexandrov on 05.07.16.
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
        return "MyInputItem: " + value;
    }
}
