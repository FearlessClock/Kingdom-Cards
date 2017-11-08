package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.util.List;

public class Troll extends Card {

	public Troll(){
		super();
		this.race = "Troll";
	}

	public void power(Board b, Deck d, Player p1, Player p2) {
		List<Card> cardsP1 = b.getPlayer1Cards();
		b.setPlayer1Cards(b.getPlayer2Cards());
		b.setPlayer2Cards(cardsP1);
	}
}
