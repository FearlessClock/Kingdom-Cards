package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Troll extends Card {

	public Troll(){
		super();
		this.race = "Troll";
	}

	public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
		List<Card> cardsP1 = b.getPlayerAICards();
		b.setPlayerAICards(b.getPlayer1Cards());
		b.setPlayer1Cards(cardsP1);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
