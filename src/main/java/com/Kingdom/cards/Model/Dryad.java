package com.Kingdom.cards.Model;

import java.util.Random;

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

	Card chosenCard;
	Stage stage = new Stage();
	Button card;

	public Dryad() {
		super();
		this.race = "Dryad";
	}

	public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn) {
		if (playerTurn.equals(PlayerTurn.player1)) {

			VBox root = new VBox(b.getPlayerAICards().size() + 10);
			Label modalityLabel = new Label("Choose a card");
			root.getChildren().add(modalityLabel);


			for (int i = 0; i < b.getPlayerAICards().size(); i++) {
				card = new Button(b.getPlayerAICards().get(i).GetRace());
				root.getChildren().add(card);
				card.setOnAction(e -> actionPerformed(e, b, playerTurn));
			}

			Scene scene = new Scene(root, 300, 600);
			stage.setScene(scene);
			stage.show();

		}

		else if (playerTurn.equals(PlayerTurn.playerAI)) {
            if (b.getPlayer1Cards().size() > 0) {
                Random rand = new Random();
                int randVal = rand.nextInt(b.getPlayer1Cards().size());
                
                b.addCard(b.getCard(randVal, playerTurn), playerTurn);
                b.removeCard(b.getCard(randVal, playerTurn), playerTurn);
                }
        }
	}

	public void actionPerformed(ActionEvent e, Board b, PlayerTurn playerTurn) {
		
		
		Button button = (Button) e.getSource();
		String race = button.getText();
		
		if ("Troll".equals(race)) {
			chosenCard = new Troll();
		} 
		
		else if ("Korrigan".equals(race)) {
			chosenCard = new Korrigan();
		}
		
		else if ("Goblin".equals(race)) {
			chosenCard = new Goblin();
		} 
		else if ("Elf".equals(race)) {
			chosenCard = new Elf();
		} 
		
		else if ("Dryad".equals(race)) {
			chosenCard = new Dryad();
		}
		
		else if ("Gnome".equals(race)){
			chosenCard = new Gnome();
		}

		if (chosenCard != null) {
			b.addCard(chosenCard, playerTurn);
			b.removeCard(chosenCard, playerTurn);
		}
		stage.close();
	}

}
