package com.Kingdom.cards.Model;

import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;


public class Goblin extends Card {

	public Goblin(){
		super();
		this.race = "Goblin";
	}

	public void Power(Hand ourHand, Hand opponentHand){
		Hand tmpHand = new Hand();
		tmpHand = opponentHand;
		opponentHand = ourHand;
		ourHand = tmpHand;
	}
}
