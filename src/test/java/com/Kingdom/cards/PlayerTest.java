package com.Kingdom.cards;

import com.Kingdom.cards.Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player;
	Deck deck;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		deck = new Deck(8);
	}

	@Test
	public void Draw() {
		int sizeDeck = deck.Size(); // deck size before draw card
		int sizeHand = player.SizeHand(); // hand size before draw card

		player.Draw(deck); // draw card

		Assert.assertEquals(sizeDeck - 1, deck.Size()); // test if card remove
														// from deck
		Assert.assertEquals(sizeHand + 1, player.SizeHand()); // test if card
																// add to hand
	}

	@Test
	public void PlayCard() {
		for (int i = 0; i < 5; i++) { // Draw 5 cards in hand of player
			player.Draw(deck);
		}
		int sizeHand = player.SizeHand();
		Card card1 = player.hand.PlayCard(0); // Get the first card (we will
												// play it for test)

		// Assert.assertEquals(true, player.board.contains(card1)); // Test if
		// card1 is place on board
		Assert.assertEquals(sizeHand - 1, player.SizeHand()); // Test if size of
																// hand decrease
		// Assert.assertEquals(sizeBoard + 1, player.SizeBoard()); // Test if
		// size of board increase
	}

	@Test
	public void ScoreBoard() {
		while (!deck.IsEmpty()) {
			player.Draw(deck);
		}
		player.PlayCard(0); // Play 1 card => score = 1
		// Assert.assertEquals(1, player.ScoreBoard()); // Score after 1 card
		// play

		// play one of each card => 1 (current) + 5 (number of cards) + 3 (bonus
		// point)

		// Assert.assertEquals(9, player.ScoreBoard());
	}

}
