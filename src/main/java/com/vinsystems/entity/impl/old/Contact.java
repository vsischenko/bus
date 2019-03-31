package com.vinsystems.entity.impl.old;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private String name;
    @Column
    private String number;
    @Column
    private Date dateOfAdd=new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "sontactbook",
                    joinColumns = @JoinColumn(name="id_contact"),
                    inverseJoinColumns = @JoinColumn(name = "id_bus"))
    private HBus bus;



    public Date getDateOfAdd() {
        return dateOfAdd;
    }


    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public HBus getBus() {
        return bus;
    }

    public void setBus(HBus bus) {
        this.bus = bus;
    }
}
