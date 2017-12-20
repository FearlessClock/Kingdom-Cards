package com.Kingdom.cards.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
