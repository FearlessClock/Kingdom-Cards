package com.Kingdom.cards;

public class Elf extends Card{


	public Elf(){
		super();
		this.race = "Elf";
	}

	public String toString(){
		return ("You get a " + race + "\nPower : Copy and use the power of one of the card in front of you" );

	}

	public void Power(){
		// Need to have the class Kingdom
		// Select a card in the kingdom
		// Use the power
	}

}
