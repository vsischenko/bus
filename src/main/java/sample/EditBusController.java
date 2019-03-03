package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditBusController implements Initializable {

    @FXML
    Label labGosnum;

    @FXML
    Label labRoute;

    @FXML
    Label labModel;

    @FXML
    Label labColor;

    @FXML
    Label labTable;

    @FXML
    Label labSeenDate;

    @FXML
    Label labPark;

    @FXML
    TextArea tareaNotes;

    @FXML
    TextField tFieldGosnum;

    @FXML
    TextField tFieldRoute;

    @FXML
    ChoiceBox cboxModel;

    @FXML
    ChoiceBox cboxColor;

    @FXML
    ChoiceBox cboxTable;

    @FXML
    DatePicker dpickerSeenDate;

    @FXML
    Label labPl1;

    @FXML
    Label labPl2;

    @FXML
    Label labPl3;

    @FXML
    TextArea tareaLog;

    @FXML
    Button bEditGosnum;

    @FXML
    Button bEditRoute;

    @FXML
    Button bEditModel;

    @FXML
    Button bEditColor;

    @FXML
    Button bEditTable;

    @FXML
    Button bEditSeenDate;

    @FXML
    Button bEditPark;

    @FXML
    Button bEditNotes;

    @FXML
    Button bEditPhoto;

    @FXML
    Button bSetGosnum;

    @FXML
    Button bSetRoute;

    @FXML
    Button bSetModel;

    @FXML
    Button bsetColor;

    @FXML
    Button bSetTable;

    @FXML
    Button bSetSeenDate;

    @FXML
    Button bSetPark;

    @FXML
    Button bSetNotes;

    @FXML
    Button bSetPhoto;

    @FXML
    Button bPlNaSklad1;

    @FXML
    Button bPlNaSklad2;

    @FXML
    Button bPlNaSklad3;

    @FXML
    Button bSetPlastatusToLost1;

    @FXML
    Button bSetPlastatusToLost2;

    @FXML
    Button bSetPlastatusToLost3;

    @FXML
    Button bSaveAll;

    @FXML
    Button bCloseWindow;

    public Bus selectedBus = BusMainViewController.getSelectedBus();
    public String tableOnfrontwindowInfo = "Свободно";



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (selectedBus.getNumTabOnFrontWindow()) {
                tableOnfrontwindowInfo="Занято";
        }

        labGosnum.setText(labGosnum.getText()+" " + selectedBus.getNumber());
        labRoute.setText(labRoute.getText()+" "+selectedBus.getRoute());
        labColor.setText(labColor.getText()+" "+selectedBus.getBusColor());
        labModel.setText(labModel.getText()+" "+selectedBus.getModel());
        labTable.setText(labTable.getText()+" "+tableOnfrontwindowInfo);
        labSeenDate.setText(labSeenDate.getText()+" " + selectedBus.getSeenDate());
        labPark.setText(labPark.getText()+" " + selectedBus.getPark());
        tareaNotes.setText(selectedBus.getNotes());

    }


    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) bCloseWindow.getScene().getWindow();

        stage.close();
    }
}
