package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;
import java.util.ArrayList;
import java.util.List;

public class Dryad extends Card {

	public Dryad() {
		super();
		this.race = "Dryad";
		this.view.getStyleClass().add("dryad");
		this.view.setText("- Dryad -");
		System.out.println("Dryad added");
	}

	public void power(Board b, Deck d, Player p1, Player p2) {

	}

}
