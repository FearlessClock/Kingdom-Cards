package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;

import java.util.Random;

public class Korrigan extends Card {
	public Korrigan(){
		super();
		this.race = "Korrigan";
		this.view.getStyleClass().add("korrigan");
		//this.view.setText(" - Korrigan - ");
		System.out.println("korrigan added");
	}

	public void power(Board b, Deck d, Player p1, Player p2) {
		Random rand = new Random();
		for (int i = 0 ; i < 2 ; i++){
			if(p2.hand.getNmbrOfCards() > 0)
			{
				int cardPos = p2.hand.selectCard(); // selectionne une carte dans le deck adverse
				p1.hand.addToHand((p2.hand.getHand().get(cardPos)));
				p2.hand.removeFromHand(cardPos);
			}
		}
	}
}
