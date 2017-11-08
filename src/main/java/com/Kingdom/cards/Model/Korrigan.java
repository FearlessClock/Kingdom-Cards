package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Korrigan extends Card {
	public Korrigan(){
		super();
		this.race = "Korrigan";
	}

	public void power(Board b, Deck d, Player p1, Player p2) {
		Random rand = new Random();
		//TODO The hand count doesn't change and so cause crash when getting the second card and taking the last one
		for (int i = 0 ; i < 2 ; i++){
			int cardPos = (rand.nextInt(p2.hand.GetNmbrOfCards()));
			p1.hand.AddToHand((p2.hand.getHand().get(cardPos)));
			p2.hand.getHand().remove(cardPos);

		}
	}
}
