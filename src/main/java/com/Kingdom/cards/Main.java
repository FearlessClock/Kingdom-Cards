package com.Kingdom.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../../Game.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setTitle("Game");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    public static void main(String[] args) {
        //Change the "<RollingFile name="rollingfile" fileName="D:/Log4JLogs/smtrace.log"" Line to the location
        //where you want to save your logs
        System.setProperty("log4j.configurationFile", "log4j2-test");
        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined To Be :: " + System.getProperty("log4j.configurationFile"));
        System.out.print("Hello, world\n");
        launch(args);
    }
}