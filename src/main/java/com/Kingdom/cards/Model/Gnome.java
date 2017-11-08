package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import javafx.scene.control.Button;

import java.util.List;

public class Gnome extends Card {

	public Gnome() {
		super();
		this.race = "Gnome";
	}

	@Override
	public void Power(Board b) {
		// TODO Auto-generated method stub
		
	}

		/*Card c = player.Draw(deck);
		Button b = new Button(c.GetRace());
		player1Field.getChildren().add(b);
=======
	public void Power(Player player, Deck deck, Board board) {
>>>>>>> master
		player.Draw(deck);
		player.Draw(deck);
		System.out.println("I'm a gnome !!");*/
	}

