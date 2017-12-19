package com.Kingdom.cards.View;

import com.Kingdom.cards.Controllers.MainMenuController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuView
{
    private MainMenuController mainMenuController = new MainMenuController();

    @FXML
    public void initialize() {

    }

    @FXML
    private void btnStartCall(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainMenuController.LaunchGame(stage);
    }

    @FXML
    private void btnQuitCall(ActionEvent event) {
        Platform.exit();
    }
}
