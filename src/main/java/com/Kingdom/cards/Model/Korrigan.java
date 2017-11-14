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
		//TODO The hand count doesn't change and so cause crash when getting the second card and taking the last one
		for (int i = 0 ; i < 2 ; i++){
			if(p2.hand.getNmbrOfCards() > 0)
			{
				int cardPos = (rand.nextInt(p2.hand.getNmbrOfCards()));
				p1.hand.addToHand((p2.hand.getHand().get(cardPos)));
				p2.hand.removeFromHand(cardPos);
			}
		}
	}
}
