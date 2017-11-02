package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public String pseudo;
	public Hand hand;
	
	public Player(){
		hand = new Hand();
	}
	
	public Player(String pseudo){
		this.pseudo = pseudo;
		hand = new Hand();
	}
	
	public void Draw(Deck deck){
		hand.AddToHand(deck.GetFirstCard());
	}
	
	public int SizeHand(){
		return hand.nmbrOfCardsProperty.get();
	}

	public Card PlayCard(int cardIndex){
		return hand.PlayCard(cardIndex);
	}
}
