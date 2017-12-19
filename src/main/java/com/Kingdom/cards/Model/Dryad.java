package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;

import java.util.Random;

public class Dryad extends Card {


    public Dryad() {
        super();
        this.race = "Dryad";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn, FieldView fieldView) {
        if (fieldView != null && playerTurn.equals(PlayerTurn.player1)) {
            fieldView.PopupPowerForDryad(b, playerTurn);
        }
        // If it's the AI turn
        else if (playerTurn.equals(PlayerTurn.playerAI)) {
            if (b.getPlayer1Cards().size() > 0)// Check if there is cards in the opponent field
            {
                Random rand = new Random();
                int randVal = rand.nextInt(b.getPlayer1Cards().size());// Random choose a card in the opponent's field

                // Add the card chosen to the AI field and remove it from the player's field
                b.addCard(b.getCard(randVal, playerTurn), playerTurn);
                b.removeCard(b.getCard(randVal, playerTurn), playerTurn);
            }
        }
    }

}
