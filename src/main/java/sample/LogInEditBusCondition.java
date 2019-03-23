package sample;

import java.util.Date;

//содержит и выводит в окно временный лог изменений при редактировании автобуса. Наглядно показывает что на что меняем.

public class LogInEditBusCondition {
    String gosnumber = "";
    String route = "";
    String model = "";
    String color = "";
    String park = "";
    String picture = "";
    String table = "";
    String nGosnumber = "";
    String notes = "";
    String nRoute = "";
    String nModel = "";
    String nColor = "";
    String nPark = "";
    String nTable = "";
    Date seendate=null;
    Date nSeendate=null;
    String nNotes = "";

    public String getNotes() {
        return notes;
    }



    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getnNotes() {
        return nNotes;
    }

    public void setnNotes(String nNotes) {
        this.nNotes = nNotes;
    }

    public String getGosnumber() {
        return gosnumber;
    }

    public void setGosnumber(String gosnumber) {
        this.gosnumber = gosnumber;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getnGosnumber() {
        return nGosnumber;
    }

    public void setnGosnumber(String nGosnumber) {
        this.nGosnumber = nGosnumber;

    }

    public Date getSeendate() {
        return seendate;
    }

    public void setSeendate(Date seendate) {
        this.seendate = seendate;
    }

    public Date getnSeendate() {
        return nSeendate;
    }

    public void setnSeendate(Date nSeendate) {
        this.nSeendate = nSeendate;
    }

    public String getnRoute() {
        return nRoute;
    }

    public void setnRoute(String nRoute) {
        this.nRoute = nRoute;
    }

    public String getNmodel() {
        return nModel;
    }

    public void setNmodel(String nmodel) {
        this.nModel = nmodel;
    }

    public String getnColor() {
        return nColor;
    }

    public void setnColor(String nColor) {
        this.nColor = nColor;
    }

    public String getnPark() {
        return nPark;
    }

    public void setnPark(String nPark) {
        this.nPark = nPark;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getnTable() {
        return nTable;
    }

    public void setnTable(String nTable) {
        this.nTable = nTable;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getnModel() {
        return nModel;
    }

    public void setnModel(String nModel) {
        this.nModel = nModel;
    }

    @Override
    public String toString() {
        return "LogInEditBusCondition{" +
                "gosnumber='" + gosnumber + '\'' +
                ", route='" + route + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", park='" + park + '\'' +
                ", nGosnumber='" + nGosnumber + '\'' +
                ", nRoute='" + nRoute + '\'' +
                ", nModel='" + nModel + '\'' +
                ", nColor='" + nColor + '\'' +
                ", nPark='" + nPark + '\'' +
                '}';
    }

    public String aString() {
        String result = "";
        if (nGosnumber.length() > 0) {
            result += "Автобус госномер: " + getGosnumber() + " меняет ГОСНОМЕР на " + getnGosnumber() + "\n";
        }
        if (nRoute.length() > 0) {
            result += "Автобус госномер: " + getGosnumber() + " меняет МАРШРУТ с " + getRoute() + " на " + getnRoute() + "\n";
        }
        if (picture.length() > 0) {
            result += "Не подгрузилась картинка из базы\n";
        }
        if (nModel.length() > 0) {
            result += "Госномер: " + getGosnumber() + " перешел на автобус модели " + nModel + "\n";
        }

        if (nColor.length() > 0) {
            result += "Автобус госномер: " + getGosnumber() + " перекрашен в новый цвет: " + nColor + "\n";
        }

        if (nTable.length()>0) {
            result += "Автобус госномер: " + getGosnumber() + " перенесена табличка и теперь: " + nTable + "\n";
        }

        if (nSeendate!=null) {
            result += "Автобус госномер: " + getGosnumber() + " видели : " + nSeendate + "\n";
        }

        if (nPark.length()>0) {
            result += "Автобус госномер: " + getGosnumber() + " перешел в парк : " + nPark + "\n";
        }

        if (nNotes.length()!=notes.length()) {
            result += "Автобус госномер: " + getGosnumber() + " изменил заметку : " + nNotes + "\n";
        } else if (notes.length()==0&&nNotes.length()>0) {
            result += "Автобус госномер: " + getGosnumber() + " получил заметку : " + nNotes + "\n";
        }

        return result;
    }
}
