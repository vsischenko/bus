package hibernate.entity.entity;

import javax.persistence.*;
import java.sql.Blob;
@Entity
@Table
public class Hphoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Blob photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photoset_id")
    private Hphotoset photoset;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Hphotoset getPhotoset() {
        return photoset;
    }

    public void setPhotoset(Hphotoset photoset) {
        this.photoset = photoset;
    }
}
