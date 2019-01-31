package hibernate.entity.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "bus")
public class HBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private int route;
    @NaturalId
    @Column (name="number")
    private String number;
    @Column
    private String model;

    @Embedded
    private SpecialMarks specialMarks;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="bus")
    private List<Contact> contacts;

    @Column
    @OneToMany (fetch=FetchType.EAGER, mappedBy = "bus")
    private List<Hplanshet> planshets= new ArrayList<>();

    @Column
    private Date addDate;
    @Column
    private Date seenDate = getAddDate();
    @Column
    @OneToMany (fetch=FetchType.LAZY, mappedBy = "bus")
    private List<History> history = new ArrayList<History>();
    @Column
    private boolean inArch;
    @Column
    private boolean numTabOnFrontWindow;
    @Column
    private String park;
    @Column
    private String color;

    public SpecialMarks getSpecialMarks() {
        return specialMarks;
    }

    public void setSpecialMarks(SpecialMarks specialMarks) {
        this.specialMarks = specialMarks;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getSeenDate() {
        return seenDate;
    }

    public void setSeenDate(Date seenDate) {
        this.seenDate = seenDate;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public boolean isInArch() {
        return inArch;
    }

    public void setInArch(boolean inArch) {
        this.inArch = inArch;
    }

    public boolean isNumTabOnFrontWindow() {
        return numTabOnFrontWindow;
    }

    public void setNumTabOnFrontWindow(boolean numTabOnFrontWindow) {
        this.numTabOnFrontWindow = numTabOnFrontWindow;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public void setContactToContactList (Contact cont) {
        getContacts().add(cont);
    }

    public List<Hplanshet> getPlanshets() {
        return planshets;
    }

    public void setPlanshets(List<Hplanshet> planshets) {
        this.planshets = planshets;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "ID=" + ID +
                ", route=" + route +
                ", number='" + number + '\'' +
                ", model='" + model + '\'' +
              //  ", contacts=" + contacts +
                ", addDate=" + addDate +
                ", seenDate=" + seenDate +
               // ", history=" + history +
                ", inArch=" + inArch +
                ", numTabOnFrontWindow=" + numTabOnFrontWindow +
                ", park='" + park + '\'' +
                ", color='" + color + '\'' +
                "планшеты есть?" + planshets.size() +
                '}';
    }
}
