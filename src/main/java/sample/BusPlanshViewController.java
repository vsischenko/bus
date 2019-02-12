package sample;

import hibernate.entity.Hiberbus;
import hibernate.entity.entity.Hplanshet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class BusPlanshViewController implements Initializable {

    @FXML
    private TableView<Planshet> planshetTable;

    @FXML
    private TableColumn<Planshet, String> invNum;

    @FXML
    private TableColumn<Planshet, String> position;

    @FXML
    private TableColumn<Planshet, Date> seenDate;

    @FXML
    private TableColumn<Planshet, String> state;

    @FXML
    private TableColumn<Planshet, String> plType;

    @FXML
    private TableColumn<Planshet, Date> mountDate;

    @FXML
    private TableColumn<Planshet, Date> dismountDate;

    @FXML
    TextField filterField;

    @FXML
    TextArea logField;

    public ObservableList<Planshet> list = FXCollections.observableArrayList(

    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        invNum.setCellValueFactory(new PropertyValueFactory<Planshet, String>("invNumber"));
        plType.setCellValueFactory(new PropertyValueFactory<Planshet, String>("typeOfPlanshet"));
        state.setCellValueFactory(new PropertyValueFactory<Planshet, String>("state"));
        position.setCellValueFactory(new PropertyValueFactory<Planshet, String>("bus_gosnumber"));
        mountDate.setCellValueFactory(new PropertyValueFactory<Planshet,Date>("mountDate"));
        // list.add(new Planshet("001","Алюм","ok"));
        list.add(Hiberbus.getPlanshet(1));
     //   list.add(Hiberbus.getPlanshet(2));


        planshetTable.setItems(list);
       // Hiberbus.replacePlanshet("001", "0000");
      //  Hiberbus.replacePlanshet("002","0000");
     //   planshetTable.setItems(list);
    }

    //TODO Переключение View на Базу Автобусов
    public void setSceenMainBus(ActionEvent actionEvent) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/busMainView.fxml"));

        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stageTheEventSourceNodeBelongs.setScene(new Scene(home_page_parent));


    }
}
