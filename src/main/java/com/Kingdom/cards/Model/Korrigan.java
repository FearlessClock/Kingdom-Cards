package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;

public class Korrigan extends Card {
	public Korrigan(){
		super();
		this.race = "Korrigan";
	}

	public void power(Board b, Deck d, Player p1, Player p2) {
		for (int i = 0 ; i < 2 ; i++){
			int cardPos = (int) (Math.random() * p1.hand.GetNmbrOfCards());
			p1.hand.AddToHand((p2.hand.getHand().get(cardPos)));
			p2.hand.getHand().remove(cardPos);
		}
	}
}
