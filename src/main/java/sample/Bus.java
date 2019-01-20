package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Bus {

    private final SimpleIntegerProperty ID;

    private final SimpleStringProperty route;

    private final SimpleStringProperty number;

    private final SimpleStringProperty model;

   // private List<Contact> contacts;

    private final SimpleObjectProperty<Date> addDate;

    private final SimpleObjectProperty<Date> seenDate;

   // private List<History> history = new ArrayList<History>();

    private boolean inArch;

    private boolean numTabOnFrontWindow;

    private final SimpleStringProperty park;

    private final SimpleStringProperty busColor;

    public Bus() {
        ID = null;
        this.route = null;
        this.number = null;
        this.model = null;
        this.addDate = null;
        this.seenDate = null;
        this.numTabOnFrontWindow = false;
        this.park = null;
        this.busColor = null;
    }

    public Bus(Integer id, String route, String number, String model, Date addDate, Date seenDate, boolean numTabOnFrontWindow, String park, String busColor) {
        ID = new SimpleIntegerProperty(id);
        this.route = new SimpleStringProperty(route);
        this.number = new SimpleStringProperty(number);
        this.model = new SimpleStringProperty(model);
        this.addDate = new SimpleObjectProperty<Date>(addDate);
        this.seenDate = new SimpleObjectProperty<Date>(seenDate);
        this.numTabOnFrontWindow = numTabOnFrontWindow;
        this.park = new SimpleStringProperty(park);
        this.busColor = new SimpleStringProperty(busColor);
    }

    public int getID() {
        return ID.get();
    }

    public String getRoute() {
        return route.get();
    }

    public String getNumber() {
        return number.get();
    }


    public String getModel() {
        return model.get();
    }


    public Date getAddDate() {
        return addDate.get();
    }

       public Date getSeenDate() {
        return seenDate.get();
    }


    public boolean isInArch() {
        return inArch;
    }

    public boolean isNumTabOnFrontWindow() {
        return numTabOnFrontWindow;
    }

    public String getPark() {
        return park.get();
    }


    public String getBusColor() {
        return busColor.get();
    }

    @Override
    public String toString() {
        return "Bus{" +
                "ID=" + ID +
                ", route=" + route +
                ", number=" + number +
                ", model=" + model +
                ", addDate=" + addDate +
                ", seenDate=" + seenDate +
                ", inArch=" + inArch +
                ", numTabOnFrontWindow=" + numTabOnFrontWindow +
                ", park=" + park +
                ", busColor=" + busColor +
                '}';
    }
}
