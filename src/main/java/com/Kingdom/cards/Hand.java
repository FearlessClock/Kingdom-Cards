package com.Kingdom.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<Card>();
	int nbCard = 0;
	
	public Hand(int nbCard, List<Card> deck){
		this.nbCard = nbCard;
		for (int i = 0 ; i < nbCard ; i++){
			hand.add(Draw(deck));
		}
	}
	
	public Card Draw(List<Card> deck){
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}
	
	
}
