package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Hand;
import com.Kingdom.cards.Model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class AI extends Player {

	//Arguments
	Random rand;
	
	//Constructor
	public AI() {
		rand = new Random();
		this.pseudo = "";
		hand = new Hand();
	}

	//Functions
	public Card PlayCard() {
		if(this.SizeHand() > 0)//Play only if there is cards on his hand
		{
			int nbOfCardsInHand = this.SizeHand();
			int cardIndex = rand.nextInt(nbOfCardsInHand);//Select a random card to play it
			return hand.playCard(cardIndex);//Play the selected card
		}
		else//Play no one card
		{
			return null;
		}
	}
}