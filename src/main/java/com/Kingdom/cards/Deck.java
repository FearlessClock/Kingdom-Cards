package com.Kingdom.cards;

import com.Kingdom.cards.Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	protected List<Card> deck = new ArrayList<Card>();

	public Deck(int amountOfRaces) {
		for (int i = 0; i < amountOfRaces; i++) { // Add amountOfRaces Troll
													// Card to deck
			deck.add(new Troll());
		}
		for (int i = 0; i < amountOfRaces; i++) { // Add amountOfRaces Elf Card
													// to deck
			deck.add(new Elf());
		}
		for (int i = 0; i < amountOfRaces; i++) { // Add amountOfRaces Gnome
													// Card to deck
			deck.add(new Gnome());
		}
		for (int i = 0; i < amountOfRaces; i++) { // Add amountOfRaces Korrigan
													// Card to deck
			deck.add(new Korrigan());
		}
		for (int i = 0; i < amountOfRaces; i++) { // Add amountOfRaces Goblin
													// Card to deck
			deck.add(new Goblin());
		}
		for (int i = 0; i < amountOfRaces; i++) { // Add amountOfRaces Dryad
													// Card to deck
			deck.add(new Dryad());
		}
	}

	protected List<Card> GetDeck() {
		return deck;
	}

	public Card GetFirstCard() { // return the first card and remove it from the
									// deck
		//TODO End game when deck is empty
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	public void Shuffle() { // Shuffle the deck
		Collections.shuffle(deck);
	}

	protected Boolean IsEmpty() {
		return deck.size() == 0;
	}

	public int Size() {
		return deck.size();
	}
}
