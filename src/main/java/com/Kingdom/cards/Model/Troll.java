package com.Kingdom.cards.Model;

import com.Kingdom.cards.Model.Card;

public class Troll extends Card {

	public Troll(){
		super();
		this.name = "Troll";
	}

	public String toString(){
		return ("You get a " + race + "\nPower : Swap the cards in front of you with the cards in front of your opponent" );

	}

	public void Power(){
		// Need the class Kingdom
		// Switch the kingdom
	}
}
