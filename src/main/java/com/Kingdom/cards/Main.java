package com.Kingdom.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Parent mainMenuScene;
    Parent fieldScene;
    Parent scoreScene;
    Parent optionsScene;

    public static void main(String[] args) {
        //Change the "<RollingFile name="rollingfile" fileName="D:/Log4JLogs/smtrace.log"" Line to the location
        //where you want to save your logs
        System.setProperty("log4j.configurationFile", "log4j2-test");
        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined To Be :: " + System.getProperty("log4j.configurationFile"));
        Application.launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/fxml/MainMenuView.fxml"));
        Parent fieldScene = FXMLLoader.load(getClass().getResource("/fxml/FieldView.fxml"));
        Parent scoreScene = FXMLLoader.load(getClass().getResource("/fxml/ScoreView.fxml"));
        Parent optionsScene = FXMLLoader.load(getClass().getResource("/fxml/OptionsScene.fxml"));
        Scene scene = new Scene(mainMenu,600,600);
        primaryStage.setTitle("Kingdom Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}