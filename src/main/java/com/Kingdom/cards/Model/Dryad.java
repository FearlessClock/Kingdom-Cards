package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import com.Kingdom.cards.PlayerTurn;

public class Dryad extends Card {

	private ActionEvent event;
	public Dryad() {
		super();
		this.race = "Dryad";
	}

	public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn) {
		if (playerTurn.equals(PlayerTurn.player1)){
			Stage stage = new Stage();
	        stage.initModality(Modality.APPLICATION_MODAL);
	        
	        VBox root = new VBox(b.getPlayerAICards().size() + 10);
	        Label modalityLabel = new Label("Choose a card");
	        root.getChildren().add(modalityLabel);
	        
	        Button card;
	        for (int i = 0; i < b.getPlayerAICards().size(); i++){
	        	card = new Button(b.getPlayerAICards().get(i).GetRace());
	        	root.getChildren().add(card);
	        }
	        
	        //closeButton.setOnAction(e -> stage.close());
	        Scene scene = new Scene(root, 1900, 1000);
	        stage.setScene(scene);
	        stage.show();
	       
	        
		}
		
        else if (playerTurn.equals(PlayerTurn.playerAI)) {
        	
        }
	}

}
