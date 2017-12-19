package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;

import java.util.List;

public class Goblin extends Card
{

    public Goblin() {
        super();
        this.race = "Goblin";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn, FieldView fieldView) {
        List<Card> tmpHand = p2.hand.getHand();// Get the hand of the opponent and store it
        // Switch hands
        p2.hand.setHand(p1.hand.getHand());
        p1.hand.setHand(tmpHand);
    }
}
