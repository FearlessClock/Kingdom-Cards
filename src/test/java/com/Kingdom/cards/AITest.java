package com.Kingdom.cards;

import com.Kingdom.cards.Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AITest {
	AI playerAI;
	Deck deck;

	@Before
	public void setUp() throws Exception {
		playerAI = new AI();
		deck = new Deck(8);
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
	public void PlayCard() {
		for (int i = 0; i < 5; i++) { // Draw 5 cards in hand of playerAI
			playerAI.Draw(deck);
		}
		int sizeHand = playerAI.SizeHand();
		Card card1 = playerAI.PlayCard(); // Get the first card (we will play it
											// for test)

		// Assert.assertEquals(true, playerAI.board.contains(card1)); // Test if
		// card1 is place on board
		Assert.assertEquals(sizeHand - 1, playerAI.SizeHand()); // Test if size
																// of hand
																// decrease
		// Assert.assertEquals(sizeBoard + 1, playerAI.SizeBoard()); // Test if
		// size of board increase
	}

	@Test
	public void ScoreBoard() {
		while (!deck.IsEmpty()) {
			playerAI.Draw(deck);
		}
		playerAI.PlayCard(); // Play 1 card => score = 1
		// Assert.assertEquals(1, playerAI.ScoreBoard()); // Score after 1 card
		// play

		// play one of each card => 1 (current) + 5 (number of cards) + 3 (bonus
		// point)

		// Assert.assertEquals(9, playerAI.ScoreBoard());
	}

}
