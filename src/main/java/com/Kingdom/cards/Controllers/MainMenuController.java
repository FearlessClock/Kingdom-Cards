package com.Kingdom.cards.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class MainMenuController {
    public MainMenuController() {

    }

    public void LaunchGame(Stage stage) throws IOException {
        Parent fieldScene = FXMLLoader.load(getClass().getResource("/fxml/FieldView.fxml"));
        Scene scene = new Scene(fieldScene);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
