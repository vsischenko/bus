package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="uni")
public class Studentt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name ="name")
    private String name;

    @Column (name = "sname")
    private String sname;

    @Column (name = "age")
    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSname() {
        return sname;
    }

    public int getAge() {
        return age;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAge(int age) {this.age = age;}
}
