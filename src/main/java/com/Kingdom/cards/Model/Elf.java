package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;


public class Elf extends Card{

	public Elf() {
		super();
		this.race = "Elf";
		this.view.getStyleClass().add("elf");
		this.view.setText(" - Elf - ");
		System.out.println("Elf added");

	}

	public void power(Board b, Deck d, Player p1, Player p2) {
        // Need to have the class Kingdom
        // Select a card in the kingdom
        // Use the power

	}

}
