package com.Kingdom.cards;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Card {

	public Goblin(){
		super();
		this.race = "Goblin";
	}
	
	public String toString(){
		return ("You get a " + race + "\nPower : Switch your hand with you opponent" );
		
	}
	
	public void Power(List<Card> opponentHand, List<Card> ourHand){
		List<Card> tmpHand = new ArrayList<Card>();
		tmpHand = opponentHand;
		opponentHand = ourHand;
		ourHand = tmpHand;
	}
}
