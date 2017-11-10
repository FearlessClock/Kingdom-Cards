package com.Kingdom.cards.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class InGameMenuController {
    @FXML
    public void OnQuit()
    {
        Platform.exit();
    }

    @FXML
    public void OnResume(ActionEvent event)
    {
        Scene scene = ((Button)event.getSource()).getScene();

    }
    @FXML
    public void initialize() {

    }
}
