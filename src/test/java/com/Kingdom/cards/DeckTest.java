package com.Kingdom.cards;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DeckTest {
    Deck deck;

	@Before
	public void setUp() throws Exception {
         deck = new Deck();
	}

	@Test
	public void ShuffleTest() {
		// Create 2 deck (no shuffle) => equals
		Deck deckNoShuffle = new Deck();

		Assert.assertEquals(deck.GetDeck(), deckNoShuffle.GetDeck()); // Before shuffle => equals
		deck.Shuffle(); // Shuffle 1 deck
		Assert.assertNotEquals(deck.GetDeck(), deckNoShuffle.GetDeck()); // After shuffle => not equals
	}
	
	@Test
	public void GetCardTest(){
		
		int lenght = deck.GetDeck().size(); // get initial size
		Card first_card = deck.GetDeck().get(0); // get initial first card

		Assert.assertEquals(deck.GetFirstCard(), first_card);  // check if first card remove is the initial first card
		Assert.assertEquals(deck.GetDeck().size(), lenght - 1); // check if size is ok with 1 card remove
		
	}

}
