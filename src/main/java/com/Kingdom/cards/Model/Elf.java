package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;


public class Elf extends Card {

    public Elf() {
        super();
        this.race = "Elf";

    }

    public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
        List<Card> cards;
        if (playerTurn.equals(FieldController.PlayerTurn.player1)) {
            cards = b.getPlayerAICards();
            if (cards.size() > 0) {
                Random rand = new Random();
                int randVal = rand.nextInt(cards.size());
                b.getPlayer1Cards().add(cards.get(randVal));
                cards.remove(randVal);
                if (cards.size() > 0) {
                    randVal = rand.nextInt(cards.size());
                    b.getPlayer1Cards().add(cards.get(randVal));
                    cards.remove(randVal);
                }
            }
        } else if (playerTurn.equals(FieldController.PlayerTurn.playerAI)) {
            cards = b.getPlayer1Cards();
            if (cards.size() > 0) {
                Random rand = new Random();
                int randVal = rand.nextInt(cards.size());
                b.getPlayerAICards().add(cards.get(randVal));
                cards.remove(randVal);
                if (cards.size() > 0) {
                    randVal = rand.nextInt(cards.size());
                    b.getPlayerAICards().add(cards.get(randVal));
                    cards.remove(randVal);
                }
            }
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
