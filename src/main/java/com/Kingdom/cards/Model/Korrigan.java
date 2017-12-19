package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;

import java.util.Random;

public class Korrigan extends Card
{
    public Korrigan()
    {
        super();
        this.race = "Korrigan";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn, FieldView fieldView)
    {
        Random rand = new Random();
        //Take 2 cards
        for (int i = 0; i < 2; i++)
        {
            if (p2.hand.getNmbrOfCards() > 0)//Check if the hand isn't empty
            {
                int cardPos = (rand.nextInt(p2.hand.getNmbrOfCards()));//Random the index of the card taken 
                p1.hand.addToHand((p2.hand.getHand().get(cardPos)));//Add the chosen card to the hand of the player
                p2.hand.removeFromHand(cardPos);//remove the card from the opponent
            }
        }
    }
}
