package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;

import java.util.List;

public class Goblin extends Card {

	public Goblin() {
		super();
		this.race = "Goblin";
		this.view.getStyleClass().add("goblin");
		//this.view.setText(" - Goblin - ");
		System.out.println("goblin added");
	}

	public void power(Board b, Deck d, Player p1, Player p2, Boolean endTurn) {
		List<Card> tmpHand = p2.hand.getHand();
		p2.hand.setHand(p1.hand.getHand());
		p1.hand.setHand(tmpHand);
	}
}
