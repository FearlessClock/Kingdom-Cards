package com.Kingdom.cards.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class EndGameController {

    @FXML
    public void initialize() {

    }

    @FXML
    public void keyPressed(KeyEvent keyEvent) throws IOException {
        switch (keyEvent.getCode())
        {
            case ESCAPE:
                try {
                    LoadMainMenu((Node)keyEvent.getSource());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void OnQuit(ActionEvent ev) {
        try {
            LoadMainMenu((Node)ev.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void LoadMainMenu(Node n) throws IOException {
        Stage stage = (Stage) (n).getScene().getWindow();
        Parent mainMenuScene = FXMLLoader.load(getClass().getResource("/fxml/MainMenuView.fxml"));
        Scene scene = new Scene(mainMenuScene);
        stage.setScene(scene);
        stage.show();
    }
}
