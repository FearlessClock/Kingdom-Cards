package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.util.List;

public class Gnome extends Card {

	public Gnome(){
		super();
		this.race = "Gnome";
	}

	public void Power(Player player, Deck deck, Board board){
		player.Draw(deck);
		player.Draw(deck);
	}
}
