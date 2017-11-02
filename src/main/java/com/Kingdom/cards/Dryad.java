package com.Kingdom.cards;

public class Dryad extends Card{

	public Dryad(){
		super();
		this.race = "Dryad";
	}

	public String toString(){
		return ("You get a " + race + "\nPower : Steal a card in front of your opponent and add it in front of you without activating its power" );

	}
	public void power(){
		// Need to have the class Kingdom
		// Opponent Kingdom.remove
		// Our Kingdom.add
	}

}
