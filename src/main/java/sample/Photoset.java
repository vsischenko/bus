package sample;

import hibernate.entity.entity.Hphoto;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Photoset {


   private int id;

    private final SimpleObjectProperty<Date> dateOfPhoto;

    private List<Hphoto> listofPhotos = new ArrayList<Hphoto>();


    public Photoset(Date dateOfPhotoset) {

        this.dateOfPhoto = new SimpleObjectProperty<Date>(dateOfPhotoset);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfPhoto() {
        return dateOfPhoto.get();
    }


    public void setDateOfPhoto(Date dateOfPhoto) {
        this.dateOfPhoto.set(dateOfPhoto);
    }

    public List<Hphoto> getListofPhotos() {
        return listofPhotos;
    }

    public void setListofPhotos(List<Hphoto> listofPhotos) {
        this.listofPhotos = listofPhotos;
    }
}
