package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import javafx.scene.control.Button;

import java.util.List;

public class Gnome extends Card {

	public Gnome(){
		super();
		this.race = "Gnome";
	}

	public void Power(Player player, Deck deck){
		Card c = player.Draw(deck);
		Button b = new Button(c.GetRace());
		player1Field.getChildren().add(b);
		player.Draw(deck);
		player.Draw(deck);
		System.out.println("I'm a gnome !!");
	}
}
