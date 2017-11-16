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

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Label text;

    @FXML
    private void btnStartCall(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent fieldScene = FXMLLoader.load(getClass().getResource("/fxml/FieldView.fxml"));
        Scene scene = new Scene(fieldScene);
        stage.setScene(scene);
        stage.show();
    }

	@FXML
	private void btnQuitCall(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void btnOptionsCall(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent fieldScene = FXMLLoader.load(getClass().getResource("/fxml/OptionsView.fxml"));
        Scene scene = new Scene(fieldScene);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnScoreCall(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent fieldScene = FXMLLoader.load(getClass().getResource("/fxml/ScoreView.fxml"));
        Scene scene = new Scene(fieldScene);
        stage.setScene(scene);
        stage.show();
    }

    public MainMenuController() {

    }

    @FXML
    public void initialize() {

    }
}
