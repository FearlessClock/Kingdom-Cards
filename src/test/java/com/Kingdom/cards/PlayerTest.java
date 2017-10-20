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
	public void Draw() {
		int sizeDeck = deck.Size(); // deck size before draw card
		int sizeHand = player.SizeHand(); // hand size before draw card
		
		player.Draw(deck); // draw card 
		
		Assert.assertEquals(sizeDeck - 1, deck.Size()); // test if card remove from deck
		Assert.assertEquals(sizeHand + 1, player.SizeHand()); // test if card add to hand
	}
	
	@Test
	public void PlayerCard(){
		for(int i = 0; i < 5; i++){ // Draw 5 cards in hand of player
			player.Draw(deck);
		}
		int sizeHand = player.SizeHand();
		int sizeBoard = player.SizeBoard();
		Card card1 = player.hand.get(0); // Get the first card (we will play it for test)
		player.PlayCard(card1); // Play the first card
		
		Assert.assertEquals(true, player.board.contains(card1)); // Test if card1 is place on board
		Assert.assertEquals(sizeHand - 1, player.SizeHand()); // Test if size of hand decrease
		Assert.assertEquals(sizeBoard + 1, player.SizeBoard()); // Test if size of board increase
	}

}
