package com.Kingdom.cards.Controllers;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FieldController {
	
	@FXML
	Button btnDraw;
	
	Deck deck;
	
	Player p1;
	Player p2;
	
	@FXML
	Label lblShowCardNumber;
	
	
	@FXML
	public void initialize() {
		deck = new Deck();
		p1 = new Player();
		p2 = new Player();
		for(int i = 0; i < 5; i++){
			p1.Draw(deck);
			p2.Draw(deck);
		}
		lblShowCardNumber.setText(Integer.toString(deck.Size()) + " Card left in deck");
	}
	
	
	public void DrawCard(ActionEvent event){
		p1.Draw(deck);
		lblShowCardNumber.setText(Integer.toString(deck.Size()) + " Card left in deck");
	}
}
