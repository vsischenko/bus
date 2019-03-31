package com.vinsystems.entity.impl.old;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "photoset")
public class Hphotoset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date dateOfPhotoset;

    @Column
    @OneToMany (fetch=FetchType.LAZY, mappedBy = "photoset")
    List<Hphoto> listofPhotos = new ArrayList<Hphoto>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id")
    private HBus bus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDateOfPhotoset() {
        return dateOfPhotoset;
    }

    public void setDateOfPhotoset(Date dateOfPhotoset) {
        this.dateOfPhotoset = dateOfPhotoset;
    }

    public List<Hphoto> getListofPhotos() {
        return listofPhotos;
    }

    public void setListofPhotos(List<Hphoto> listofPhotos) {
        this.listofPhotos = listofPhotos;
    }

    public HBus getBus() {
        return bus;
    }

    public void setBus(HBus bus) {
        this.bus = bus;
    }
}
