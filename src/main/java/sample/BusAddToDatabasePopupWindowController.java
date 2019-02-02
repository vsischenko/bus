package sample;

import hibernate.entity.Hiberbus;
import hibernate.entity.entity.HBus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusAddToDatabasePopupWindowController implements Initializable {

    @FXML
    private ComboBox<String> menuButtonModelOfBus;

    @FXML
    private TextField textFieldBusGosnumber;

    @FXML
    private ComboBox<String> comboRouteNumber;

    @FXML
    private ComboBox<String> comboColorOfBus;

    @FXML
    private ComboBox<String> comboNumTableOnFrontWindow;

    @FXML
    private ComboBox<String> comboPark;

    @FXML
    private TextArea textFieldSpesialMarks;

    @FXML
    private Button buttonAddBusToDatabase;

    @FXML
    private Button buttonClearFieldsButton;

    @FXML
    private Button buttonClose;

    @FXML
    private TextArea textAreaLog;

    private Desktop desktop = Desktop.getDesktop();

    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menuButtonModelOfBus.getItems().setAll("Богдан 92", "Богдан 91", "Иван", "Эталон", "Рута");
        comboRouteNumber.getItems().setAll("121", "146", "175", "185", "203");
        comboColorOfBus.getItems().setAll("Желтый", "Белый", "Синий", "Фиолетовый", "Кобинированный");
        comboNumTableOnFrontWindow.getItems().setAll("На лобовом", "Лобовое свободно");
        comboPark.getItems().setAll("Вираж");


    }




    public void addBusToDatabase(ActionEvent actionEvent) throws FileNotFoundException {

        textAreaLog.setText("!");

        ArrayList busParam = new ArrayList<String>();

        String gosnum = textFieldBusGosnumber.getText();
        gosnum = gosnum.toUpperCase();
        if (gosnum.length() < 4) {
            textAreaLog.setText("Не валидный номер автобуса");
        } else {

            if (Hiberbus.exists(gosnum)) {
                textAreaLog.setText("Уже есть в базе такой госномер");
            } else {
                busParam.add(gosnum);
            }

        }

        if (menuButtonModelOfBus.getValue()==null) {
            textAreaLog.setText(textAreaLog.getText() + " ++ "
                    + "Не выбрана модель автобуса");
        } else {
            busParam.add("" + menuButtonModelOfBus.getValue());
        }

        if (comboRouteNumber.getValue()==null) {
            textAreaLog.setText(textAreaLog.getText() + " ++ "
                    + "Не выбран маршрут");
        } else {
            busParam.add("" + comboRouteNumber.getValue());
        }

        if (comboColorOfBus.getValue()==null) {
            textAreaLog.setText(textAreaLog.getText() + " ++ "
                    + "Не выбран цвет");
        } else {
            busParam.add("" + comboColorOfBus.getValue());
        }

        if (comboNumTableOnFrontWindow.getValue()==null) {
            textAreaLog.setText(textAreaLog.getText() + " ++ "
                    + "Где табличка?");
        } else {
            busParam.add(comboNumTableOnFrontWindow.getValue());
        }

        if (comboPark.getValue()==null) {
            textAreaLog.setText(textAreaLog.getText() + " ++ "
                    + "Какой парк?");
        } else {
            busParam.add(comboPark.getValue());
        }

        if (busParam.size()>5) {
            busParam.add("" + textFieldSpesialMarks.getText());
        }








        if (busParam.size() >= 6) {
            textAreaLog.setText(textAreaLog.getText()+"Все срослось");
            formClear();

            Hiberbus.addBusToDatabase(busParam,getFile());
        }

    }


    void formClear() {
        menuButtonModelOfBus.valueProperty().set(null);
        textFieldBusGosnumber.clear();
        comboRouteNumber.valueProperty().set(null);
        comboColorOfBus.valueProperty().set(null);
        comboNumTableOnFrontWindow.valueProperty().set(null);
        comboPark.valueProperty().set(null);
    }



    public void formClearButton(ActionEvent actionEvent) {
        textAreaLog.setText("Все готово для ввода");
        formClear();
    }

    public void closeWindow(ActionEvent actionEvent) {

        Stage stage = (Stage) buttonClose.getScene().getWindow();


        stage.close();

    }

    public void openFileChooserDialog(ActionEvent actionEvent) {

        Stage stage = (Stage) buttonClose.getScene().getWindow();
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            setFile(file);
        }
    }

    private void openFile(File file) {

        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    BusAddToDatabasePopupWindowController.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }
}
