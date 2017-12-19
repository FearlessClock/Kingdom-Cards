package com.Kingdom.cards;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Hand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class HandTest {
	FieldController fieldController;
	@org.junit.Before
	public void setUp() throws Exception {
		fieldController = new FieldController(null, PlayerTurn.player1);
	}

	@Test
	public void Draw() {
		Hand hand = fieldController.getPlayer1().hand;
		int sizeOfHand = hand.getHand().size();
		fieldController.DrawCard();
		Assert.assertEquals(sizeOfHand+1, fieldController.getPlayer1().hand.getHand().size());
	}

}
