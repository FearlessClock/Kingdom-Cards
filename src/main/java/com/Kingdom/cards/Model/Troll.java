package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.PlayerTurn;

import java.util.List;

public class Troll extends Card
{

    public Troll()
    {
        super();
        this.race = "Troll";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn)
    {
        List<Card> cardsP1 = b.getPlayerAICards();//Get the field of the opponent and store it
        //Switch both fields
        b.setPlayerAICards(b.getPlayer1Cards());
        b.setPlayer1Cards(cardsP1);
    }
}
