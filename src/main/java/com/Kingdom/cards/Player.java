package com.Kingdom.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Player {
	
	public String pseudo;
	protected List<Card> hand = new ArrayList<Card>();
	
	public Player(){
		
	}
	
	public Player(String pseudo){
		this.pseudo = pseudo;
	}
	
	protected Deck Draw(Deck deck){
		hand.add(deck.GetFirstCard());
		return deck;
	}
	
	public int SizeHand(){
		return hand.size();
	}
}
