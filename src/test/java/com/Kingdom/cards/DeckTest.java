package com.Kingdom.cards;

import static org.junit.Assert.assertArrayEquals;

import com.Kingdom.cards.Model.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	private Deck deck;

	@Before
	public void setUp() throws Exception {
		deck = new Deck(8);
	}

	@Test
	public void Shuffle() {
		// Create 2 deck (no shuffle) => equalsd
		Deck deckNoShuffle = new Deck(8);

		Assert.assertEquals(deckNoShuffle.GetDeck(), deck.GetDeck()); // Before
																		// shuffle
																		// =>
																		// equals
		deck.Shuffle(); // Shuffle 1 deck
		Assert.assertNotEquals(deckNoShuffle.GetDeck(), deck.GetDeck()); // After
																			// shuffle
																			// =>
																			// not
																			// equals
	}

	@Test
	public void GetCard() {

		int length = deck.Size(); // get initial size
		Card first_card = deck.GetDeck().get(0); // get initial first card

		Assert.assertEquals(first_card, deck.GetFirstCard()); // check if first
																// card remove
																// is the
																// initial first
																// card
		Assert.assertEquals(length - 1, deck.Size()); // check if size is ok
														// with 1 card remove

	}

	@Test
	public void IsEmpty() {
		Assert.assertEquals(false, deck.IsEmpty());
		while (deck.Size() > 0) {
			deck.GetFirstCard();
		}
		Assert.assertEquals(true, deck.IsEmpty());
	}

}
