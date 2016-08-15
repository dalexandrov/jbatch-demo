package local.batch.chunk.twitter.extract;

import java.util.Date;

/**
 * Created by Dmitry Alexandrov on 13.07.16.
 */
public class TwitRecord {

    private Date date;

    private String message;

    public TwitRecord(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
