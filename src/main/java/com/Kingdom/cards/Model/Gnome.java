package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.util.List;

public class Gnome extends Card {

	public Gnome(){
		super();
		this.race = "Gnome";
	}

	public void power(Board b, Deck d, Player p1, Player p2) {
		p1.Draw(d);
		p1.Draw(d);

	}
}
