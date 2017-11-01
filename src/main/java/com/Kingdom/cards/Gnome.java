package com.Kingdom.cards;

import java.util.List;


public class Gnome extends Card {
	
	public Gnome(){
		super();
		this.race = "Gnome";
	}
	
	public String toString(){
		return ("You get a " + race + "\nPower : Draw 2 cards" );
		
	}
	
	public void Power(List<Card> hand, List<Card> deck){
		((Hand) hand).Draw(deck);
		((Hand) hand).Draw(deck);
	}
}
