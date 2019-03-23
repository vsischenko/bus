package sample;

import hibernate.entity.Hiberbus;
import hibernate.entity.entity.Hphoto;
import hibernate.entity.entity.Hphotoset;
import hibernate.entity.entity.Hplanshet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class PhotosetViewController implements Initializable {

    public Photoset selectedPhotoset;

    @FXML
    private ImageView imView01;

    @FXML
    private ImageView imView02;

    @FXML
    private ImageView imView03;

    @FXML
    private ImageView imView04;

    @FXML
    private ImageView imView05;

    @FXML
    private ImageView imView06;



    @FXML
    private TableView<Photoset> tableViewTableOfPhotosets;

    @FXML
    private TableColumn<Photoset, Date> dateOfPhotoset;

    @FXML
    private Label labelBusNumber;

    public ObservableList<Photoset> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(BusMainViewController.getSelectedBus().getNumber());
        labelBusNumber.setText("Фотоистория автобуса № " + BusMainViewController.getSelectedBus().getNumber());
        list.addAll(Hiberbus.getPhotosetFromDatabase(BusMainViewController.getSelectedBus().getNumber()));


        dateOfPhotoset.setCellValueFactory(new PropertyValueFactory<Photoset, Date>("dateOfPhoto"));

        tableViewTableOfPhotosets.setItems(list);
    }

    public void showPhotoset(MouseEvent mouseEvent) throws SQLException, IOException {
        selectedPhotoset = tableViewTableOfPhotosets.getFocusModel().getFocusedItem();
        int id = selectedPhotoset.getId();
        List<Hphoto> list = Hiberbus.getPhotosetById(id);

        Image background = Hiberbus.readPhotoFromPics(1);
        imView01.setImage(background);
        imView02.setImage(background);
        imView03.setImage(background);
        imView04.setImage(background);
        imView05.setImage(background);
        imView06.setImage(background);



        System.out.println(" ------------------------------------- Кол-во фоток в фотосете должно быть " + list.size());

        if (list.size()>0) {
         Image image = new Image(list.get(0).getPhoto().getBinaryStream());
            imView01.setImage(image);
        }

        if (list.size()>1) {
            Image image = new Image(list.get(1).getPhoto().getBinaryStream());
            imView02.setImage(image);
        }

        if (list.size()>2) {
            Image image = new Image(list.get(2).getPhoto().getBinaryStream());
            imView03.setImage(image);
        }

        if (list.size()>3) {
            Image image = new Image(list.get(3).getPhoto().getBinaryStream());
            imView04.setImage(image);
        }

        if (list.size()>4) {
            Image image = new Image(list.get(4).getPhoto().getBinaryStream());
            imView05.setImage(image);
        }

        if (list.size()>5) {
            Image  image = new Image(list.get(5).getPhoto().getBinaryStream());
            imView06.setImage(image);
        }


    }
}
