package local.batch.invoicing.processing;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Created by Dmitry Alexandrov on 28.07.16.
 */
@Entity
@Table(name = "INVOICE_DATABASE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Invoice.findAll", query = "SELECT c FROM Invoice c")})
public class Invoice {

    @Id
    private int id;

    @Column(name = "PERSON_ID")
    private int personId;

    @Column(name = "EMAIL")
    private String email;

    @Lob
    @Column(length=1000, name="DATA")
    private byte[] data;

    public Invoice() {
    }

    public Invoice(int id, int personId, String email, byte[] data) {
        this.id = id;
        this.personId = personId;
        this.email = email;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (personId != invoice.personId) return false;
        if (email != null ? !email.equals(invoice.email) : invoice.email != null) return false;
        return Arrays.equals(data, invoice.data);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", personId=" + personId +
                ", email='" + email + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
