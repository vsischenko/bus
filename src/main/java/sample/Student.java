package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty sname;
    private final SimpleIntegerProperty age;

    public Student(Integer id, String name, String sname, Integer age) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.sname = new SimpleStringProperty(sname);
        this.age = new SimpleIntegerProperty(age);
    }

    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getSname() {
        return sname.get();
    }

    public Integer getAge() {
        return age.get();
    }
}
