package hibernate.entity.entity;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table (name = "planshet_history")
public class PlanshetHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planshet_id")
    private Hplanshet planshet;

    @Column
    private String stateOfPlanshet;

    @Column
    private String log;

//Конструктор стартовый. Подразумевает, что с планшетом все ок. Создается первая запись о планшете.
    public PlanshetHistory(Hplanshet planshet) {
        this.date = new Date();
        this.planshet = planshet;
        this.stateOfPlanshet = stateOfPlanshet;
    }

    public PlanshetHistory() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Hplanshet getPlanshet() {
        return planshet;
    }

    public void setPlanshet(Hplanshet planshet) {
        this.planshet = planshet;
    }

    public String getStateOfPlanshet() {
        return stateOfPlanshet;
    }

    public void setStateOfPlanshet(String stateOfPlanshet) {
        this.stateOfPlanshet = stateOfPlanshet;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public PlanshetHistory(Date date, Hplanshet planshet, String stateOfPlanshet, String log) {
        this.date = date;
        this.planshet = planshet;
        this.stateOfPlanshet = stateOfPlanshet;
        this.log = log;
    }
}
