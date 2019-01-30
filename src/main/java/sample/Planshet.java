package sample;

import hibernate.entity.entity.HBus;
import hibernate.entity.entity.Hplanshet;
import hibernate.entity.entity.PlanshetHistory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Planshet {

    private final SimpleIntegerProperty ID;

    private final SimpleStringProperty invNumber;

    private final SimpleStringProperty typeOfPlanshet;

    private final SimpleObjectProperty mountDate;

    private final SimpleObjectProperty<Date> seenDate;

    private final SimpleObjectProperty<Date> dismountDate;

    private final  SimpleStringProperty bus_gosnumber;

    private final SimpleStringProperty state;

  //  private final List<PlanshetHistory> planshetHistory;


    public Planshet(String invNumber,
                    String typeOfPlanshet,
                    String state
                    ) {
        this.ID = new SimpleIntegerProperty(1);
        this.invNumber = new SimpleStringProperty(invNumber);
        this.typeOfPlanshet = new SimpleStringProperty(typeOfPlanshet);

        this.mountDate = null;
        this.seenDate = null;
        this.dismountDate = null;
       this.bus_gosnumber = new SimpleStringProperty("Не установлен");
        this.state = new SimpleStringProperty(state);
    }


    //Конструктор на тот случай, когда я вытаскиваю данные из таблицы
    public Planshet(int ID, String invNumber,  String typeOfPlanshet, Date mountDate, Date seenDate, Date dismountDate, String busGosnum, String state) {
        this.ID = new SimpleIntegerProperty(ID);
        this.invNumber = new SimpleStringProperty(invNumber);
        this.typeOfPlanshet = new SimpleStringProperty(typeOfPlanshet);
        this.mountDate = new SimpleObjectProperty<Date>(mountDate);
        this.seenDate = new SimpleObjectProperty<Date>(seenDate);
        this.dismountDate = new SimpleObjectProperty<Date>(dismountDate);
        this.bus_gosnumber = new SimpleStringProperty(busGosnum);
        this.state = new SimpleStringProperty(state);
    }

    public int getID() {
        return ID.get();
    }


    public String getInvNumber() {
        return invNumber.get();
    }


    public String getTypeOfPlanshet() {
        return typeOfPlanshet.get();
    }


    public Object getMountDate() {
        return mountDate.get();
    }

    public Date getSeenDate() {
        return seenDate.get();
    }


    public Date getDismountDate() {
        return dismountDate.get();
    }

    public String getBus_gosnumber() {
        return bus_gosnumber.get();
    }


    public String getState() {
        return state.get();
    }

    public void setBus_gosnumber(String bus_gosnumber) {
        this.bus_gosnumber.set(bus_gosnumber);
    }

    @Override
    public String toString() {
        return "Planshet{" +
                "ID=" + ID +
                ", invNumber=" + invNumber +
                ", typeOfPlanshet=" + typeOfPlanshet +
                ", mountDate=" + mountDate +
                ", seenDate=" + seenDate +
                ", dismountDate=" + dismountDate +
                ", bus_gosnumber=" + bus_gosnumber +
                ", state=" + state +
                '}';
    }
}
