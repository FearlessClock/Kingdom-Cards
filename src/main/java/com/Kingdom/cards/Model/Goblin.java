package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Goblin extends Card {

	public Goblin() {
		super();
		this.race = "Goblin";
	}

	public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
		List<Card> tmpHand = p2.hand.getHand();
		p2.hand.setHand(p1.hand.getHand());
		p1.hand.setHand(tmpHand);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
