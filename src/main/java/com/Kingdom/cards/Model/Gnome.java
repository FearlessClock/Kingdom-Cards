package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;

public class Gnome extends Card {

	public Gnome(){
		super();
		this.race = "Gnome";
		this.view.getStyleClass().add("gnome");
		//this.view.setText(" - Gnome - ");
		System.out.println("gnome added");
	}

	public void power(Board b, Deck d, Player p1, Player p2, Boolean endTurn) {
		p1.Draw(d);
		p1.Draw(d);
	}
}
