package com.Kingdom.cards.Model;

import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;

public class Korrigan extends Card {
	public Korrigan(){
		super();
		this.race = "Korrigan";
	}

	public String toString(){
		return ("You get a " + race + "\nPower : Draw 2 random cards within your opponent hand" );

	}

	public void Power(List<Card> opponentHand , List<Card> ourHand){
		for (int i = 0 ; i < 2 ; i++){
			int cardPos = (int) (Math.random() * opponentHand.size());
			ourHand.add(opponentHand.get(cardPos));
			opponentHand.remove(cardPos);
		}


	}
}
