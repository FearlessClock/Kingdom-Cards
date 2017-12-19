package com.Kingdom.cards;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Model.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AITest {
	FieldController fieldController;
	AI playerAI;
	Deck deck;
	@Before
	public void setUp() throws Exception {
		fieldController = new FieldController(null, null);
		deck = fieldController.getDeck();
		playerAI = fieldController.getPlayerAI();
	}

	@Test
	public void Draw() {
		int sizeDeck = deck.Size(); // deck size before draw card
		int sizeHand = playerAI.SizeHand(); // hand size before draw card

		playerAI.Draw(deck); // draw card

		Assert.assertEquals(sizeDeck - 1, deck.Size()); // test if card remove
														// from deck
		Assert.assertEquals(sizeHand + 1, playerAI.SizeHand()); // test if card
																// add to hand
	}

    @Test
    public void SetFields()
    {
        List<Card> boardCards = new ArrayList<Card>();
        boardCards.add(new Gnome());
        List<Card> boardCardsOpp = new ArrayList<Card>();
        boardCards.add(new Elf());

        playerAI.SetFields(boardCards, boardCardsOpp);

        Assert.assertEquals("Gnome", playerAI.getBoardCards().get(0).GetRace().toString());
        Assert.assertEquals("Elf", playerAI.getBoardCardsOpp().get(0).GetRace().toString());
    }
	@Test
	public void PlayCard() {
		for (int i = 0; i < 5; i++) { // Draw 5 cards in hand of playerAI
			playerAI.Draw(fieldController.getDeck());
		}
		int sizeHand = playerAI.SizeHand();
		Card card1 = playerAI.PlayCard(0); // Get the first card (we will play it
											// for test)
		fieldController.getBoard().getPlayerAICards().add(card1);
		Assert.assertEquals(true, fieldController.getBoard().getPlayerAICards().contains(card1)); // Test if
		// card1 is place on board
		Assert.assertEquals(sizeHand - 1, playerAI.SizeHand()); // Test if size
																// of hand
																// decrease
		}

}
