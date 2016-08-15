package local.batch.chunk.exception;

import java.io.Serializable;

/**
 * Created by Dmitry Alexandrov on 09.07.16.
 */
public class MyOutputRecord implements Serializable {
    private int id;

    public MyOutputRecord(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MyOutputRecord that = (MyOutputRecord) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "MyOutputRecord: " + id;
    }
}
