package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Hand;
import com.Kingdom.cards.Model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI extends Player
{

    // Arguments
    private Random rand;
    private List<Card> boardCards;
    private List<Card> boardCardsOpp;

    // Get
    public List<Card> getBoardCards() {
        return boardCards;
    }

    public List<Card> getBoardCardsOpp() {
        return boardCardsOpp;
    }

    // Constructor
    public AI() {
        rand = new Random();
        this.pseudo = "";
        hand = new Hand();
        this.boardCards = new ArrayList<Card>();
        this.boardCardsOpp = new ArrayList<Card>();
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
            for (Card card : lCardsInhand)
            {
                index++;
                if ("Troll".equals(card.GetRace().toString()))
                {
                    // If the opponent have more cards on his field
                    if (boardCards.size() < boardCardsOpp.size())
                    {
                        cardIndex = index;// Select the Troll card to switch fields
                    }
                }
            }
            return hand.playCard(cardIndex);// Play the selected card
        } else// Play no card
        {
            return null;
        }
    }

    public void SetFields(List<Card> boardCards, List<Card> boardCardsOpp) {
        this.boardCards = boardCards;
        this.boardCardsOpp = boardCardsOpp;
    }

}