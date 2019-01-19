package sample;

import hibernate.entity.Hiber;
import hibernate.entity.Studentt;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    private Student selectedStudent;

    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student, Integer> id;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> sname;
    @FXML
    private TableColumn<Student, Integer> age;

    @FXML
    private Label lname;
    @FXML
    private Label lsname;
    @FXML
    private Label lage;


    @FXML
    TextField edName;
    @FXML
    TextField edSname;
    @FXML
    TextField edAge;

    @FXML
    Button saveEdit;


    public ObservableList<Student> list = FXCollections.observableArrayList(

            /*new Student(1, "Петька", "Betman", 33),
            new Student(2, "Васька", "Бывалый", 13),
            new Student(3, "Полька", "ЛА", 23),
            new Student(4, "Олька", "Ка", 43)*/

    );


    public static Student parsHiberStudent(Studentt studentFromDb) {
        int id = studentFromDb.getId();
        String name = studentFromDb.getName();
        String sname = studentFromDb.getSname();
        int age = studentFromDb.getAge();
        System.out.println("Получен студент из базы с ID: " + id + ", ИМЯ: " + name + ", ФАМИЛИЯ : " + sname + ", ВОЗРАСТ: " + age);

        return new Student(id, name, sname, age);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        sname.setCellValueFactory(new PropertyValueFactory<Student, String>("sname"));
        age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));


        list.addAll(Hiber.readStudents_HQL());


        table.setItems(list);
    }

    public void getStudent() {
        selectedStudent = table.getFocusModel().getFocusedItem();
        lname.setText("Имя : " + selectedStudent.getName());
        lsname.setText("Фамилия : " + selectedStudent.getSname());
        lage.setText("Возраст : " + selectedStudent.getAge().toString());

        System.out.println(table.getFocusModel().getFocusedItem().getName());


    }

    // По нажатию кнопки Редактировать - данные из таблицы переносятся в поля для редактирования.
    public void startEditing(ActionEvent actionEvent) {

        if (selectedStudent == null) {
            System.out.println("Студент не выбран");
        } else {
            edName.setText(selectedStudent.getName());
            edSname.setText(selectedStudent.getSname());
            edAge.setText(selectedStudent.getAge().toString());
        }

    }

    public void saveEdit(ActionEvent actionEvent) {


        Student temp = new Student(selectedStudent.getId(), edName.getText(), edSname.getText(), Integer.parseInt(edAge.getText()));

        System.out.println("Темповый объект из филдов " + temp.getName() + " создался");

        for (int i = 0; i < list.size(); i++) {
            if (temp.getId() == list.get(i).getId()) {
                list.remove(i);
            }
        }

        list.add(temp);
        edName.clear();
        edSname.clear();
        edAge.clear();

    }

    public void addStudent(ActionEvent actionEvent) {
        String regExp = "[0-9]*";

        if (edName.getText().length() < 3) {
            System.out.println("Слишком короткое имя");
        } else if (edSname.getText().length() < 3) {
            System.out.println("Слишком короткая фамилия");
        } else if (!edAge.getText().matches(regExp) || edAge.getText().length() < 1) {
            System.out.println("Размер поля " + edAge.getText().length());
            System.out.println("Допустимы только цифры");
        } else {
            System.out.println("Все срослось");
            Student tempStudent = new Student(5, edName.getText(), edSname.getText(), Integer.parseInt(edAge.getText()));
            list.add(tempStudent);
            Hiber.addStudent(edName.getText(), edSname.getText(), tempStudent.getAge());
        }

    }


}
