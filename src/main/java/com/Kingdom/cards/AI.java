package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Hand;
import com.Kingdom.cards.Model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class AI extends Player {

	Random rand;
	public AI() {
		rand = new Random();
		this.pseudo = "";
		hand = new Hand();
	}

	public Card PlayCard() {
		int nbOfCardsInHand = this.SizeHand();
		int cardIndex = rand.nextInt(nbOfCardsInHand);
		Logger logger = LogManager.getRootLogger();
		logger.trace(cardIndex);
		return hand.PlayCard(cardIndex);
	}
}