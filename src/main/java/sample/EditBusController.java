package sample;

import hibernate.entity.Hiberbus;
import hibernate.entity.entity.HBus;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    ImageView imView;

    @FXML
    TextField tFieldPark;

    @FXML
    Button bGosnumClear;

    @FXML
    Button bRouteClear;

    @FXML
    Button bParkClear;

    @FXML
    Button bModelClear;

    @FXML
    Button bColorClear;

    @FXML
    Button bTableClear;

    @FXML
    Button bSeenDateClear;

    @FXML
    Button bNotesClear;

    @FXML
    Rectangle dragAndDropRect;




    public Bus selectedBus = BusMainViewController.getSelectedBus();
    public String tableOnfrontwindowInfo = "Свободно";
    private String log = "-!-";

    public void setLog(String log) {
        this.log = this.log + " ++ " + log;
    }

    public String getLog() {
        return log;
    }

    public HBus tempBus = Hiberbus.getBus(selectedBus.getNumber());

    public LogInEditBusCondition tempBusCondition = new LogInEditBusCondition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (tareaNotes.getText().length()>0) {
            bNotesClear.setDisable(false);
        }

       tFieldGosnum.textProperty().addListener(new ChangeListener<String>(){
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
           {
               if (tFieldGosnum.getLength()==0) {
                   bGosnumClear.setDisable(true);
               } else {
                   bGosnumClear.setDisable(false);
               }

           };
       });

       tFieldRoute.textProperty().addListener(new ChangeListener<String>() {
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (tFieldRoute.getLength()==0) {
                   bRouteClear.setDisable(true);
               } else {
                   bRouteClear.setDisable(false);
               }
           }
       });

       tFieldPark.textProperty().addListener(new ChangeListener<String>() {
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (tFieldPark.getLength()==0) {
                   bParkClear.setDisable(true);
               } else {
                   bParkClear.setDisable(false);
               }
           }
       });

        cboxColor.getItems().setAll(FiltersForJFXElements.filterCboxMenu(selectedBus,"color"));
        cboxTable.getItems().setAll(FiltersForJFXElements.filterCboxMenu(selectedBus,"table"));
        cboxModel.getItems().setAll(FiltersForJFXElements.filterCboxMenu(selectedBus,"model"));

        cboxModel.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (cboxModel.getValue()!=null) {
                    bModelClear.setDisable(false);
                } else {
                    bModelClear.setDisable(true);
                }
            }
        });

        cboxColor.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (cboxColor.getValue()!=null) {
                    bColorClear.setDisable(false);
                } else {
                    bColorClear.setDisable(true);
                }
            }
        });

        cboxTable.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (cboxTable.getValue()!=null) {
                    bTableClear.setDisable(false);
                } else {
                    bTableClear.setDisable(true);
                }
            }
        });

        dpickerSeenDate.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                if (dpickerSeenDate.getValue()!=null) {
                    bSeenDateClear.setDisable(false);
                } else {
                    bSeenDateClear.setDisable(true);
                }
            }
        });

        if (selectedBus.getNumTabOnFrontWindow()) {
            tableOnfrontwindowInfo = "Занято";
        }
        labGosnum.setText(labGosnum.getText() + " " + selectedBus.getNumber());
        tempBusCondition.setGosnumber(selectedBus.getNumber());
        labRoute.setText(labRoute.getText() + " " + selectedBus.getRoute());
        tempBusCondition.setRoute(selectedBus.getRoute());
        labColor.setText(labColor.getText() + " " + selectedBus.getBusColor());
        labModel.setText(labModel.getText() + " " + selectedBus.getModel());
        labTable.setText(labTable.getText() + " " + tableOnfrontwindowInfo);
        labSeenDate.setText(labSeenDate.getText() + " " + selectedBus.getSeenDate());
        labPark.setText(labPark.getText() + " " + selectedBus.getPark());
        tempBusCondition.setNotes(selectedBus.getNotes());
        tareaNotes.setText(tempBusCondition.getNotes());
        try {
            imView.setImage(Hiberbus.readPhotoFromDbase(selectedBus.getID()));
        } catch (IOException | SQLException ex) {
            tempBusCondition.setPicture("Нет картинки");
            tareaLog.setText(tempBusCondition.aString());
        }

    }




    public void CloseWindow(ActionEvent event) {
        Stage stage = (Stage) bCloseWindow.getScene().getWindow();
        stage.close();
    }

    //Обработчик кнопки Редактирование госномера
    public void editGosnumClick(ActionEvent event) {
        bEditGosnum.setDisable(true);
        bSetGosnum.setDisable(false);
        tFieldGosnum.setDisable(false);
    }


    public void editRouteClick(ActionEvent event) {
        bEditRoute.setDisable(true);
        bSetRoute.setDisable(false);
        tFieldRoute.setDisable(false);
    }

    public void editModelClick(ActionEvent event) {
        bEditModel.setDisable(true);
        bSetModel.setDisable(false);
        cboxModel.setDisable(false);
    }

    public void editColorClick(ActionEvent event) {
        bEditColor.setDisable(true);
        bsetColor.setDisable(false);
        cboxColor.setDisable(false);
    }


    public void editTableClick(ActionEvent event) {
        bEditTable.setDisable(true);
        bSetTable.setDisable(false);
        cboxTable.setDisable(false);
    }

    public void seenDateClick(ActionEvent event) {
        bEditSeenDate.setDisable(true);
        bSetSeenDate.setDisable(false);
        dpickerSeenDate.setDisable(false);
    }

    public void editParkClick(ActionEvent event) {
        bEditPark.setDisable(true);
        bSetPark.setDisable(false);
        tFieldPark.setDisable(false);
    }

    public void editNotesClick(ActionEvent event) {
        bEditNotes.setDisable(true);
        bSetNotes.setDisable(false);
        tareaNotes.setDisable(false);
    }

    public void editPhotoClick(ActionEvent event) {
        bEditPhoto.setDisable(true);
        bSetPhoto.setDisable(false);
        dragAndDropRect.setDisable(false);
    }

    public void setGosnumClick(ActionEvent event) {
        bEditGosnum.setDisable(false);
        bSetGosnum.setDisable(true);
        tFieldGosnum.setDisable(true);
//Если я поменял госномер на новый, а потом передумал и засетил пустое поле
        if (tempBusCondition.getnGosnumber().length() > 0 && tFieldGosnum.getText().length() == 0) {
            tempBusCondition.setnGosnumber("");
            tareaLog.setText(tempBusCondition.aString());
            System.out.println(tempBusCondition);
        } else if (regExpValidation("\\d{4,5}", tFieldGosnum.getText())) {
            tempBus.setNumber(tFieldGosnum.getText());
            tempBusCondition.setnGosnumber(tFieldGosnum.getText());
            //  setLog("Номер автобуса "+selectedBus.getNumber()+" будет изменен на " + tFieldGosnum.getText());
            tareaLog.setText(tempBusCondition.aString());
        } else {
            tareaLog.setText(tareaLog.getText() + "Строка не может быть номером автобуса" + "\n");
        }

        System.out.println(tempBusCondition);
    }

    public void setRouteClick(ActionEvent event) {
        bEditRoute.setDisable(false);
        bSetRoute.setDisable(true);
        tFieldRoute.setDisable(true);

        if (regExpValidation("\\d{1,3}", tFieldRoute.getText())) {

            String text = tFieldRoute.getText();
            tempBus.setRoute(Integer.parseInt(text));
            tempBusCondition.setnRoute(text);
            setLog("Маршрут автобуса " + selectedBus.getNumber() + " будет изменен на " + tFieldRoute.getText() + "\n");
            tareaLog.setText(tempBusCondition.aString());
        } else {
            tareaLog.setText(tareaLog.getText() + " !! " + "введенная строка не может быть номером маршрута" + "\n");
        }
        System.out.println(tempBusCondition);
    }

    public void bSetModelClick(ActionEvent event) {
        bEditModel.setDisable(false);
        bSetModel.setDisable(true);
        cboxModel.setDisable(true);
        tempBusCondition.setnModel(cboxModel.getValue().toString());
        System.out.println(cboxModel.getValue().toString());
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bSetColorClick(ActionEvent event) {
        bEditColor.setDisable(false);
        bsetColor.setDisable(true);
        cboxColor.setDisable(true);
        tempBusCondition.setnColor(cboxColor.getValue().toString());
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bSetTableClick(ActionEvent event) {
        bEditTable.setDisable(false);
        bSetTable.setDisable(true);
        cboxTable.setDisable(true);
        tempBusCondition.setnTable(cboxTable.getValue().toString());
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bSetSeenDate(ActionEvent event) {
        bEditSeenDate.setDisable(false);
        bSetSeenDate.setDisable(true);
        dpickerSeenDate.setDisable(true);
        tempBusCondition.setnSeendate(DateUtils.asDate(dpickerSeenDate.getValue()));
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bSetParkClick(ActionEvent event) {
        bEditPark.setDisable(false);
        bSetPark.setDisable(true);
        labPark.setDisable(true);
        tempBusCondition.setnPark(tFieldPark.getText());
        tareaLog.setText(tempBusCondition.aString());
    }




    public boolean regExpValidation(String regExp, String textFromtField) {
        Pattern pn = Pattern.compile(regExp);
        Matcher matcher = pn.matcher(textFromtField);

        if (matcher.matches()) {
            return true;
        }

        return false;
    }

    public void bGosnumClearClick(ActionEvent event) {
        tFieldGosnum.clear();
        tempBusCondition.setnGosnumber("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bRouteClearClick(ActionEvent event) {
        tFieldRoute.clear();
        tempBusCondition.setnRoute("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bColorClearClick(ActionEvent event) {
        cboxColor.getItems().setAll(FiltersForJFXElements.filterCboxMenu(selectedBus,"color"));
        bsetColor.setDisable(true);
        bEditColor.setDisable(false);
        tempBusCondition.setnColor("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bModelClearClick(ActionEvent event) {
        cboxModel.getItems().setAll(FiltersForJFXElements.filterCboxMenu(selectedBus,"model"));
        bSetModel.setDisable(true);
        bEditModel.setDisable(false);
        tempBusCondition.setnModel("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bTableClearClick(ActionEvent event) {
        cboxTable.getItems().setAll(FiltersForJFXElements.filterCboxMenu(selectedBus,"table"));
        bSetTable.setDisable(true);
        bEditTable.setDisable(false);
        tempBusCondition.setnTable("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bSeenDateClearClick(ActionEvent event) {
        dpickerSeenDate.getEditor().clear();
        bSetSeenDate.setDisable(true);
        bEditSeenDate.setDisable(false);
        tempBusCondition.setnSeendate(null);
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bParkClearClick(ActionEvent event) {
        tFieldPark.clear();
        tempBusCondition.setnPark("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void bNotesClearClick(ActionEvent event) {
        tareaNotes.clear();
        tempBusCondition.setnNotes("");
        tareaLog.setText(tempBusCondition.aString());
    }

    public void SetNotesClick(ActionEvent event) {
        tempBusCondition.setnNotes(tareaNotes.getText());
        tareaLog.setText(tempBusCondition.aString());
        bNotesClear.setDisable(false);
        bEditNotes.setDisable(false);
        bSetNotes.setDisable(true);
    }
}
