package sample;

import hibernate.entity.Hiber;
import hibernate.entity.Hiberbus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.Table;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class BusMainViewController implements Initializable {

    @FXML
    private TableView<Bus> busTable;

    @FXML
    private TableColumn<Bus, Date> seenDate;

    @FXML
    private TableColumn<Bus, String> gosNum;

    @FXML
    private TableColumn<Bus, Integer> routeNum;

    @FXML
    private TableColumn<Bus, String> plNum;

    @FXML
    private TableColumn<Bus, String> busModel;

    @FXML
    private TableColumn<Bus, String> busColor;

    public ObservableList<Bus> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seenDate.setCellValueFactory(new PropertyValueFactory<Bus, Date>("seenDate"));
        gosNum.setCellValueFactory(new PropertyValueFactory<Bus, String>("number"));
        routeNum.setCellValueFactory(new PropertyValueFactory<Bus, Integer>("route"));
        // plNum.setCellValueFactory(new PropertyValueFactory<Bus, String>("plNum"));
        busModel.setCellValueFactory(new PropertyValueFactory<Bus, String>("model"));
        busColor.setCellValueFactory(new PropertyValueFactory<Bus, String>("busColor"));


//Вызываем метод, который считывает все данные из Таблицы Bus и загружает их в TableView
        list.addAll(entityBusToBusConverter.parsListOfEntityBus(Hiberbus.getAllInBusTable()));

        busTable.setItems(list);

    }
}
