package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;
import java.util.Random;

public class Elf extends Card
{
    // Constructor
    public Elf() {
        super();
        this.race = "Elf";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn, FieldView fieldView) {
        if (fieldView != null && playerTurn.equals(PlayerTurn.player1))
        {
            fieldView.PopupPowerForElf(b, d, p1, p2, playerTurn);
        }
        // If it's the AI turn
        else if (playerTurn.equals(PlayerTurn.playerAI))
        {
            if (b.getPlayerAICards().size() > 0)// Check if there is cards in the AI field
            {
                // Initialize random
                Random rand = new Random();
                int randVal;
                do
                {
                    randVal = rand.nextInt(b.getPlayer1Cards().size());// Choose a random card in the AI field
                } while ("Elf".equals(b.getCard(randVal, playerTurn).GetRace()));// Check if the chosen card isn't an elf

                // Add the card to the Ai's hand and remove it so it plays the power
                b.addCard(b.getCard(randVal, playerTurn), playerTurn);
                b.removeCard(b.getCard(randVal, playerTurn), playerTurn);
            }
        }
    }

}
