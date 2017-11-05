package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Hand;
import com.Kingdom.cards.Model.Player;

public class AI extends Player {

    public AI() {
        this.pseudo = "";
        hand = new Hand();
    }
        
    public Card PlayCard() {
    	int nbOfCardsInHand = this.SizeHand();
    	int cardIndex = (int) (Math.random()*nbOfCardsInHand);
        return hand.PlayCard(cardIndex);
    }
}
