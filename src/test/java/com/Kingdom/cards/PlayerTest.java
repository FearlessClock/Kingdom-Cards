package com.Kingdom.cards;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player;
	Deck deck;
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
		deck = new Deck();
	}

	@Test
	public void DrawTest() {
		int sizeDeck = deck.Size(); // deck size before draw card
		int sizeHand = player.SizeHand(); // hand size before draw card
		
		player.Draw(deck); // draw card 
		
		Assert.assertEquals(sizeDeck - 1, deck.Size()); // test if card remove from deck
		Assert.assertEquals(sizeHand + 1, player.SizeHand()); // test if card add to hand
	}

}
