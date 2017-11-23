package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;

import java.util.List;

public class Troll extends Card {

	public Troll(){
		super();
		this.race = "Troll";
		this.view.getStyleClass().add("troll");
		//this.view.setText(" - Troll - ");
		

	}

	public void power(Board b, Deck d, Player p1, Player p2, Boolean endTurn) {
		List<Card> cardsP1 = b.getPlayerAICards();
		b.setPlayerAICards(b.getPlayer1Cards());
		b.setPlayer1Cards(cardsP1);
	}
}
