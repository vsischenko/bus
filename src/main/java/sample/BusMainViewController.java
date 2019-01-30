package sample;

import com.sun.javafx.charts.Legend;
import hibernate.entity.Hiber;
import hibernate.entity.Hiberbus;
import hibernate.entity.entity.HBus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class BusMainViewController implements Initializable {

    @FXML
    private BorderPane rootPane;


    private static Bus selectedBus;

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

    @FXML
    TextField filterField;

    @FXML
    TextArea logField;

    @FXML
    private Button editBusButton;

    @FXML
    private Button addPlanshetButton;

@FXML
    private BorderPane borderPane;



    @FXML
    Label labGosnum;
    @FXML
    Label labRouteNum;
    @FXML
    Label labBusModel;
    @FXML
    Label labBusColor;
    @FXML
    Label labRoutTab;
    @FXML
    Label labAddToBase;
    @FXML
    Label labLastSeenDate;
    @FXML
    Label labPark;
    @FXML
    Label labPl;

    public static Bus getSelectedBus() {
        return selectedBus;
    }



    public ObservableList<Bus> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seenDate.setCellValueFactory(new PropertyValueFactory<Bus, Date>("seenDate"));
        gosNum.setCellValueFactory(new PropertyValueFactory<Bus, String>("number"));
        routeNum.setCellValueFactory(new PropertyValueFactory<Bus, Integer>("route"));
        plNum.setCellValueFactory(new PropertyValueFactory<Bus, String>("plNum"));
        busModel.setCellValueFactory(new PropertyValueFactory<Bus, String>("model"));
        busColor.setCellValueFactory(new PropertyValueFactory<Bus, String>("busColor"));

//Вызываем метод, который считывает все данные из Таблицы Bus и загружает их в TableView
        list.addAll(entityBusToBusConverter.parsListOfEntityBus(Hiberbus.getAllInBusTable()));
        busTable.setItems(list);
        searchBus();
    }

    public void refreshTableView () {
        list.clear();
        list.addAll(entityBusToBusConverter.parsListOfEntityBus(Hiberbus.getAllInBusTable()));
    }

    //Ищет автобус по номеру
    public void searchBus() {
        System.out.println("Старт метода поиска атобуса" + "");

        FilteredList<Bus> filteredData = new FilteredList<>(list, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Bus -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name field in your object with filter.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(Bus.getNumber()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                    // Filter matches first name.

                } else if (String.valueOf(Bus.getNumber()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Bus> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(busTable.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        busTable.setItems(sortedData);

    }

    //Выводит лог в поле logField по выбранному автобусу

    public void showLogOfSelectedBusInTableView() {
        selectedBus = busTable.getFocusModel().getFocusedItem();
        int id = selectedBus.getID();
        String logString = "";
        Bus temp = Hiberbus.getBus(id);



        if (temp.getHistory().size() == 0) {
            System.out.println("Лог пустой");
            logField.setText("Лог пустой");
        } else {
            for (int i = 0; i < temp.getHistory().size(); i++) {
                System.out.println(temp.getHistory().get(i).getAddDate() + " ++ " + temp.getHistory().get(i).getLog());
                logString += temp.getHistory().get(i).getAddDate() + " ++ " + temp.getHistory().get(i).getLog() + "\n";
            }
        }

        logField.setText(logString);

        labGosnum.setText(temp.getNumber());
        labRouteNum.setText(temp.getRoute());
        labBusModel.setText(temp.getModel());
        labBusColor.setText(temp.getBusColor());
        labLastSeenDate.setText(temp.getSeenDate().toString());
        labPark.setText(temp.getPark());
        labAddToBase.setText(temp.getAddDate().toString());

        if (temp.getNumTabOnFrontWindow()) {
            labRoutTab.setText("Наверху");
        } else {
            labRoutTab.setText("Внизу");
        }
        String infoAboutPlanshets="\"№:";
        System.out.println("Размер PlanshetList === " + temp.getPlanshetList().size() );
        if (temp.getPlanshetList().size()>0){
            for (int i =0; i<temp.getPlanshetList().size(); i++) {
               infoAboutPlanshets += temp.getPlanshetList().get(i).getInvNumber() + " статус - " + temp.getPlanshetList().get(i).getState()+ " || ";
            }
            System.out.println(infoAboutPlanshets);
            labPl.setText(infoAboutPlanshets);
            System.out.println(temp.getPlanshetList());
        } else {
            labPl.setText("Планшеты не установлены");
        }

        editBusButton.visibleProperty().set(true);
        addPlanshetButton.visibleProperty().set(true);

    }

    //TODO Кнопка переключения на ПланшетView
    public void openPlanshetBaseView(ActionEvent actionEvent) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/fxml/busPlanshView.fxml"));
//видимо, получаю текущую главную сцену
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stageTheEventSourceNodeBelongs.setScene(new Scene(home_page_parent));

    }

    public void setSceenMainBus(ActionEvent actionEvent) {

    }

    //Вызов окна Добавления планшета на автобус
    public void displayAddPlWindow(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/planshetAddToBusPopupWindow.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Установка планшета на автобус");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

//Строка для поиска в таблице
    //   Optional b = busTable.getItems().stream().filter(item -> item.getNumber().equals("0072")).findAny();

}
