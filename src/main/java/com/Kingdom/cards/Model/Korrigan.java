package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;

import java.util.Random;

public class Korrigan extends Card {
	public Korrigan(){
		super();
		this.race = "Korrigan";
	}

	public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
		Random rand = new Random();
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
