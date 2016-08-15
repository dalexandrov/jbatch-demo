package local.batch.chunk.listeners;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class MyOutputItem {
    private int id;

    public MyOutputItem() {
    }

    public MyOutputItem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyOutputItem: " + id;
    }
}
