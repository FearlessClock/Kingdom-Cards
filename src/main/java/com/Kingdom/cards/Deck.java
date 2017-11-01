package com.Kingdom.cards;
import com.Kingdom.cards.Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	protected List<Card> deck = new ArrayList<Card>();
	
	public Deck(){
		for(int i = 0; i < 7; i++){ // Add 7 Troll Card to deck
			deck.add(new Troll());
		}
		for(int i = 0; i < 7; i++){ // Add 7 Elf Card to deck
			deck.add(new Elf());
		}
		for(int i = 0; i < 7; i++){ // Add 7 Gnome Card to deck
			deck.add(new Gnome());
		}
		for(int i = 0; i < 7; i++){ // Add 7 Korrigan Card to deck
			deck.add(new Korrigan());
		}
		for(int i = 0; i < 7; i++){ // Add 7 Goblin Card to deck
			deck.add(new Goblin());
		}
		for(int i = 0; i < 7; i++){ // Add 7 Dryad Card to deck
			deck.add(new Dryad());
		}
	}
	
	protected List<Card> GetDeck(){
		return deck;
	}
	
	public Card GetFirstCard(){ // return the first card and remove it from the deck
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	protected void Shuffle(){ // Shuffle the deck
		Collections.shuffle(deck); 
	}
	
	protected Boolean IsEmpty(){
		return deck.size() == 0;
	}
	
	public int Size(){
		return deck.size();
	}
	
	protected void ShowAll(){ // Print all card name in order of the deck stack
		for(Card card : deck){
			System.out.println(card.toString());
		}
	}
}
