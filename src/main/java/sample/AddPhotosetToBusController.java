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
            System.out.println(e.getDragboard().getUrl());
            e.acceptTransferModes(TransferMode.ANY);
        }

    }

    public void handlerOnDargDrop(DragEvent e) throws IOException {

        //   FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addPhotosetToBus.fxml"));
        //  Parent root = loader.load();
        //   ImageView foo = (ImageView) loader.getNamespace().get("imV02");
        //   System.out.println(foo.getId());


        files = e.getDragboard().getFiles();
        File back = new File("src\\main\\java\\sample\\pics\\background.png");
        sizeOfFilesList = files.size();
        for (int i = 0; i < 6; i++) {
            files.add(back);
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

        setBackgroundPics();


    }

    public void setBackgroundPics() {
        try {
            Image background = new Image(new FileInputStream("src\\main\\java\\sample\\pics\\background.png"));
            imV01.setImage(background);
            imV02.setImage(background);
            imV03.setImage(background);
            imV04.setImage(background);
            imV05.setImage(background);
            imV06.setImage(background);


        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл background");
        }
    }

    public void savePhotosetToDatabase(ActionEvent actionEvent) throws FileNotFoundException, InterruptedException, SQLException {
        LocalDate dateOfPhotoset = datePicker.getValue();
        Hiberbus.createPhotoset(files, busNum, DateUtils.asDate(dateOfPhotoset), sizeOfFilesList);
        setBackgroundPics();
    }
}
