package hibernate.entity.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "pictures")
public class Pics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    Blob Picture;

    @Column
    String note;

    public int getId() {
        return id;
    }

    public Blob getPicture() {
        return Picture;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
