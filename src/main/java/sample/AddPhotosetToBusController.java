package sample;

import hibernate.entity.Hiberbus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Rectangle;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddPhotosetToBusController implements Initializable {

    @FXML
    Rectangle dragRectangle;

    @FXML
    ImageView imV01;

    @FXML
    ImageView imV02;

    @FXML
    ImageView imV03;

    @FXML
    ImageView imV04;

    @FXML
    ImageView imV05;

    @FXML
    ImageView imV06;

    @FXML
    Button butSavePhotoset;

    @FXML
    Label labBusNumber;

    @FXML
    DatePicker datePicker;

    List<File> files;

    String busNum = BusMainViewController.getSelectedBus().getNumber();

    int sizeOfFilesList = 0;

    public void handlerOnDragOver(DragEvent e) {
        if (e.getDragboard().hasFiles()) {

            e.acceptTransferModes(TransferMode.ANY);
        }

    }

    public void handlerOnDargDrop(DragEvent e) throws IOException, SQLException{

        //   FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addPhotosetToBus.fxml"));
        //  Parent root = loader.load();
        //   ImageView foo = (ImageView) loader.getNamespace().get("imV02");
        //   System.out.println(foo.getId());


        files = e.getDragboard().getFiles();
        List <Image> imageList = new ArrayList<>();

        for (int i =0; i<files.size(); i++) {
            imageList.add(new Image(new FileInputStream(files.get(i))));
        }

        Image back = Hiberbus.readPhotoFromPics(1);
        sizeOfFilesList = imageList.size();
        for (int i = sizeOfFilesList; i < 6; i++) {
            imageList.add(back);
        }

        imV01.setImage(new Image(new FileInputStream(files.get(0))));
        imV02.setImage(new Image(new FileInputStream(files.get(1))));
        imV03.setImage(new Image(new FileInputStream(files.get(2))));
        imV04.setImage(new Image(new FileInputStream(files.get(3))));
        imV05.setImage(new Image(new FileInputStream(files.get(4))));
        imV06.setImage(new Image(new FileInputStream(files.get(5))));
    }

    public void setImagesToImageView(String name, Image image) {
        ImageView imageView = new ImageView(name);
        imageView.setImage(image);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        labBusNumber.setText("Добавляем фотосет к автобусу №  " + busNum);

        try {
            setBackgroundPics();
        }
        catch (Exception e) {
            System.out.println("В добавлении фото к фотосету вылетел эксепшн, который связан с SQL");
        }



    }

    public void setBackgroundPics() throws SQLException, IOException    {

            Image background = Hiberbus.readPhotoFromPics(1);
            imV01.setImage(background);
            imV02.setImage(background);
            imV03.setImage(background);
            imV04.setImage(background);
            imV05.setImage(background);
            imV06.setImage(background);

    }

    public void savePhotosetToDatabase(ActionEvent actionEvent) throws IOException, InterruptedException, SQLException {
        LocalDate dateOfPhotoset = datePicker.getValue();
        Hiberbus.createPhotoset(files, busNum, DateUtils.asDate(dateOfPhotoset), sizeOfFilesList);
        setBackgroundPics();
    }
}
