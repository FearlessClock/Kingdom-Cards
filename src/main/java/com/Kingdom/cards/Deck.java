package com.Kingdom.cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class Deck {
	List<Card> deck = new ArrayList<Card>();
	
	public Deck(){
		for(int i = 0; i < 7; i++){ // Add 7 Troll Card to deck
			deck.add(new Troll());
		}
		for(int i = 0; i < 7; i++){ // Add 7 Elf Card to deck
			deck.add(new Elf());
		}
	}
	
	protected List<Card> GetDeck(){
		return deck;
	}
	
	protected Card GetFirstCard(){ // return the first card and remove it from the deck
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	protected void Shuffle(){ // Shuffle the deck
		Collections.shuffle(deck); 
	}
	
	
	
	protected void ShowAll(){ // Print all card name in order of the deck stack
		for(Card card : deck){
			System.out.println(card.toString());
		}
	}
}
