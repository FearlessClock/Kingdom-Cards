package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
	@org.junit.Before
	public void setUp() throws Exception {
	}

	@Test
	public void GetCardRace() throws Exception {
		Card card = new Card();

		Assert.assertEquals(card.GetRace(), "Human");
	}
}