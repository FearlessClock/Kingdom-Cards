package com.Kingdom.cards.Model;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;


public class Elf extends Card {

	Card chosenCard;
	Stage stage = new Stage();
	Button card;
	
    public Elf() {
        super();
        this.race = "Elf";

    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn) {
        if (playerTurn.equals(PlayerTurn.player1)) {
        	stage.initModality(Modality.APPLICATION_MODAL);

			VBox root = new VBox(b.getPlayer1Cards().size() + 10);
			Label modalityLabel = new Label("Choose a card");
			root.getChildren().add(modalityLabel);


			for (int i = 0; i < b.getPlayer1Cards().size(); i++) {
				if (!"Elf".equals(b.getPlayer1Cards().get(i).GetRace())){
					card = new Button(b.getPlayer1Cards().get(i).GetRace());
					root.getChildren().add(card);
					card.setOnAction(e -> actionPerformed(e, b, d, p1, p2, playerTurn));
				}
			}

			Scene scene = new Scene(root, 1900, 1000);
			stage.setScene(scene);
			stage.show();
        	
        } else if (playerTurn.equals(PlayerTurn.playerAI)) {
        	if (b.getPlayerAICards().size() > 0) {
                Random rand = new Random();
                int randVal;
                do{
                	randVal = rand.nextInt(b.getPlayer1Cards().size());
                }while("Elf".equals(b.getCard(randVal, playerTurn).GetRace()));
                
                
                b.addCard(b.getCard(randVal, playerTurn), playerTurn);
                b.removeCard(b.getCard(randVal, playerTurn), playerTurn);
                }
        }
    }
    
    public void actionPerformed(ActionEvent e, Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn) {
		
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
		
		System.out.println(chosenCard.GetRace());
		if (chosenCard != null) {
			chosenCard.power(b, d, p1, p2, playerTurn);
		}
		
		stage.close();
	}

}
