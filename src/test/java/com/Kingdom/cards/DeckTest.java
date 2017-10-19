package com.Kingdom.cards;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DeckTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void ShuffleTest() {
		// Create 2 deck (no shuffle) => equals
		Deck deck = new Deck();
		Deck deckNoShuffle = new Deck();

		Assert.assertEquals(deck.GetDeck(), deckNoShuffle.GetDeck()); // Before shuffle => equals (NOT WORKING IDK WHY !)
		deck.Shuffle(); // Shuffle 1 deck
		Assert.assertNotEquals(deck.GetDeck(), deckNoShuffle.GetDeck()); // After shuffle => not equals
	}

}
