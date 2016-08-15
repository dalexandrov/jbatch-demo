package local.batch.chunk.listeners;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class MyInputItem {
    private int id;

    public MyInputItem() {
    }

    public MyInputItem(int id) {
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
        return "MyInputItem: " + id;
    }
}
