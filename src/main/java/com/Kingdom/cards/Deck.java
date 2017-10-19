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
	
	public List<Card> GetDeck(){
		return deck;
	}
	
	public Card GetFirstCard(){
		return deck.get(0);
	}

	protected void Shuffle(){ // Shuffle the deck
		Collections.shuffle(deck); 
	}
	
	public void ShowAll(){ // Print all card name in order of the deck stack
		for(Card card : deck){
			System.out.println(card.toString());
		}
	}
}
