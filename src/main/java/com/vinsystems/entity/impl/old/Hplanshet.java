package com.vinsystems.entity.impl.old;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table (name = "planshet")
public class Hplanshet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @NaturalId
    @Column (name ="invNumber")
    private String invNumber;
    @Column
    private String typeOfPlanshet;
    @Column
    private int numOfPosition;
    @Column
    private Date mountDate;
    @Column
    private Date seenDate;
    @Column
    private Date dismountDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private HBus bus;
    @Column
    private String state;
    @Column
    @OneToMany (fetch=FetchType.LAZY, mappedBy = "planshet")
    private List<PlanshetHistory> planshetHistory=new ArrayList<>();

    public int getID() {
        return ID;
    }

    public String getInvNumber() {
        return invNumber;
    }

    public String getTypeOfPlanshet() {
        return typeOfPlanshet;
    }

    public int getNumOfPosition() {
        return numOfPosition;
    }

    public Date getMountDate() {
        return mountDate;
    }

    public Date getSeenDate() {
        return seenDate;
    }

    public Date getDismountDate() {
        return dismountDate;
    }

    public HBus getBus() {
        return bus;
    }

    public String getState() {
        return state;
    }

    public List<PlanshetHistory> getPlanshetHistory() {
        return planshetHistory;
    }

    public void setBus(HBus bus) {
        this.bus = bus;
    }

    public void setMountDate(Date mountDate) {
        this.mountDate = mountDate;
    }

    public void setSeenDate(Date seenDate) {
        this.seenDate = seenDate;
    }

    public void setDismountDate(Date dismountDate) {
        this.dismountDate = dismountDate;
    }

    public Hplanshet() {
    }

    public Hplanshet(String invNumber, String typeOfPlanshet, int numOfPosition, String state) {
        this.invNumber = invNumber;
        this.typeOfPlanshet = typeOfPlanshet;
        this.numOfPosition = numOfPosition;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Hplanshet{" +
                "invNumber='" + invNumber + '\'' +
                ", typeOfPlanshet='" + typeOfPlanshet + '\'' +
                ", bus=" + bus +
                '}';
    }
}
