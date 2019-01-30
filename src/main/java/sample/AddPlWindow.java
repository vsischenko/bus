package sample;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPlWindow {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/busMainView.fxml"));

    public AddPlWindow() throws IOException {
    }

    public static void display (Parent root, String message) {

        Stage win = new Stage();
        win.initModality(Modality.APPLICATION_MODAL);
        win.setTitle("Наши в городе");
        win.setMinWidth(300);
        win.setMinHeight(200);
        Label lab = new Label(message);

        Button CloseButton = new Button("Close");
        CloseButton.setOnAction(e ->win.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(lab,CloseButton);
        layout.setAlignment(Pos.CENTER);
        Scene sceen = new Scene(root);
        win.setScene(sceen);
        win.show();
    }
}
