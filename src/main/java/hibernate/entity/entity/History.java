package hibernate.entity.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date addDate = new Date();
    @Column
    private String log;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private HBus bus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {


        this.log = log;
    }


    public HBus getBus() {
        return bus;
    }

    public void setBus(HBus bus) {
        this.bus = bus;
    }

    public History(Date addDate, String log, HBus bus) {
        this.addDate = addDate;
        this.log = log;
        this.bus = bus;
    }

    public History() {
    }
}
