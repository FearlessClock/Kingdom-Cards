package com.Kingdom.cards.Model;

import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Card {

	public Goblin() {
		super();
		this.race = "Goblin";
	}

	public void Power(List<Card> opponentHand, List<Card> ourHand) {
		List<Card> tmpHand = new ArrayList<Card>();
		tmpHand = opponentHand;
		opponentHand = ourHand;
		ourHand = tmpHand;
	}

	public void Power(Board b, Hand AIHand, Hand playerHand) {
		// TODO Auto-generated method stub
		
	}
}
