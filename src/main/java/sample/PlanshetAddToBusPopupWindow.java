package sample;

import hibernate.entity.Hiberbus;
import hibernate.entity.entity.Hplanshet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class PlanshetAddToBusPopupWindow implements Initializable {
    int numberOfMountedPlanshet = BusMainViewController.getSelectedBus().getPlanshetList().size();

    public Planshet selectedPlanshet;

    public String selectedBusGosnumber = BusMainViewController.getSelectedBus().getNumber();

    Map rollBackHistory = new TreeMap<String, Integer>();

    @FXML
    private TableView<Planshet> planshetTable;

    @FXML
    private TableColumn<Planshet, String> invNum;

    @FXML
    private TableColumn<Planshet, String> state;

    @FXML
    private TableColumn<Planshet, String> plType;

    @FXML
    private TableColumn<Planshet, String> bus;

    @FXML
    private Label labelSelectedBus;

    @FXML
    private Label labelSelectedPlanshet;

    @FXML
    private Label labelStatusOfPlanshet;


    public ObservableList<Planshet> list = FXCollections.observableArrayList(

    );
    @FXML
    private Button closeButton;

    @FXML
    private Button buttonDisableSelection;

    @FXML
    private Button buttonMountPlanshet;

    @FXML
    private Button buttonMountSaveOperation;

    @FXML
    private Label labelSelectedBusMountedPlanshetCount;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Старт Метода");
        invNum.setCellValueFactory(new PropertyValueFactory<Planshet, String>("invNumber"));
        plType.setCellValueFactory(new PropertyValueFactory<Planshet, String>("typeOfPlanshet"));
        state.setCellValueFactory(new PropertyValueFactory<Planshet, String>("state"));
        bus.setCellValueFactory(new PropertyValueFactory<Planshet, String>("bus_gosnumber"));
        list.add(Hiberbus.getPlanshet(3));
        list.add(Hiberbus.getPlanshet(4));

        labelSelectedBus.setText("Установить планшет на: госномер : " + selectedBusGosnumber);
        labelSelectedBusMountedPlanshetCount.setText("Сейчас на автобусе установлено: " + Integer.toString(numberOfMountedPlanshet));
        planshetTable.setItems(list);

    }

    public void closeWindow(ActionEvent actionEvent) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

    public void getSelectedPlanshet() {
        selectedPlanshet = planshetTable.getFocusModel().getFocusedItem();
        System.out.println("Данные из mountGetSelectedPlanshet" + selectedPlanshet);

        labelSelectedPlanshet.setText("Выбранный планшет: " + selectedPlanshet.getInvNumber());
        labelStatusOfPlanshet.setText("Статус планшета: " + selectedPlanshet.getState());
        // labelSelectedBusMountedPlanshetCount.setText("Сейчас на автобусе установлено: " + Integer.toString(numberOfMountedPlanshet));

        if (selectedPlanshet.getBus_gosnumber().equals(selectedBusGosnumber)) {
            buttonMountPlanshet.setDisable(true);
            buttonDisableSelection.setDisable(false);
        } else {
            buttonMountPlanshet.setDisable(false);
            buttonDisableSelection.setDisable(true);
        }



    }

    //Установить выбранный планшет на Автобус
    public void mountSelectedPlanshetOnBus(ActionEvent actionEvent) {


        for (int i = 0; i < list.size(); i++) {
            if (selectedPlanshet.getInvNumber().equals(list.get(i).getInvNumber())) {
                rollBackHistory.put(list.get(i).getInvNumber(), i);
                list.get(i).setBus_gosnumber(selectedBusGosnumber);
            }
            ;
        }


        planshetTable.refresh();
        buttonDisableSelection.setVisible(true);
        labelSelectedBus.setText("Планшет " + selectedPlanshet.getInvNumber() + " установлен на автобус " + selectedBusGosnumber);
        labelStatusOfPlanshet.setText("Подтвердите сохранение");
        labelSelectedPlanshet.setText("На автобусе установлено планшетов: " + (++numberOfMountedPlanshet));
        labelSelectedBusMountedPlanshetCount.setText("Сейчас на автобусе установлено: " + Integer.toString(numberOfMountedPlanshet));
        System.out.println("Данные из mountSelectedPlanshet" + selectedPlanshet);
        buttonMountPlanshet.setDisable(true);
        buttonDisableSelection.setDisable(false);
        buttonMountSaveOperation.setDisable(false);
    }

    //Отменить перемещение
    public void dismountRollBAckOperation(ActionEvent actionEvent) {

        list.get((int) rollBackHistory.get(selectedPlanshet.getInvNumber())).setBus_gosnumber("0000");
        rollBackHistory.remove(selectedPlanshet.getInvNumber());
        planshetTable.refresh();
        buttonMountPlanshet.setDisable(false);
        buttonDisableSelection.setDisable(true);


    }

    public void saveMountSelectedPlanshetOnBus(ActionEvent actionEvent) {

        //нужно логировать установку планшета на автобус
        //нужно обновить поле bus_id в базе
        System.out.println("Содержание в rollBackHistory = " + rollBackHistory);
        List a = new ArrayList(rollBackHistory.keySet());
        System.out.println(a);

        for (int i =0; i<a.size(); i++) {

          Hiberbus.replacePlanshet((String) a.get(i),selectedBusGosnumber);

        }

    }
}
