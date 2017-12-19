package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Hand;
import com.Kingdom.cards.Model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

public class AI extends Player {

    // Arguments
    private Random rand;
    private List<Card> boardCards;
    private List<Card> boardCardsOpp;

    // Constructor
    public AI(List<Card> boardCards, List<Card> boardCardsOpp) {
        rand = new Random();
        this.pseudo = "";
        hand = new Hand();
        this.boardCards = boardCards;
        this.boardCardsOpp = boardCardsOpp;
    }

    // Functions
    public Card PlayCard() {
        if (this.SizeHand() > 0)// Play only if there is cards on his hand
        {
            // Prepared to play a random card if there is no other possibility or better thing
            int nbOfCardsInHand = this.SizeHand();
            int cardIndex = rand.nextInt(nbOfCardsInHand);// Select a random card to play it

            // Watch his hand
            List<Card> lCardsInhand = this.hand.getHand();
            int index = -1;
            for (Card card : lCardsInhand) {
                index++;
                if ("Troll".equals(card.GetRace().toString())) {
                    // If the opponent have more cards on his field
                    if (boardCards.size() < boardCardsOpp.size()) {
                        cardIndex = index;// Select the Troll card to switch fields
                        break;
                    }
                }
            }
            return hand.playCard(cardIndex);// Play the selected card
        } else// Play no one card
        {
            return null;
        }
    }
}