package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.PlayerTurn;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class Gnome extends Card {

	public Gnome(){
		super();
		this.race = "Gnome";
	}

	public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn) {
		p1.Draw(d);
		p1.Draw(d);
	}
}
