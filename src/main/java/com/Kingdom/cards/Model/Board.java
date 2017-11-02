package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List player1Cards;
    List player2Cards;

    public Board()
    {
        player1Cards = new ArrayList();
        player2Cards = new ArrayList();
    }

    public void PlayCard(Card card, FieldController.PlayerTurn playerTurn)
    {
        if(FieldController.PlayerTurn.player1 == playerTurn)
        {
            player1Cards.add(card);
        }
        else
        {
            player2Cards.add(card);
        }
    }


}
