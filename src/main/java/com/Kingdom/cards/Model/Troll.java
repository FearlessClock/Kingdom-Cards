package com.Kingdom.cards.Model;

import java.util.ArrayList;
import java.util.List;

import com.Kingdom.cards.Model.Card;

public class Troll extends Card {

	public Troll() {
		super();
		this.race = "Troll";
	}


	@Override
	public void Power(Board b) {
		List<Card> tmpList = b.getPlayerAICards();
		b.setPlayerAICards(b.getPlayer1Cards());
		b.setPlayer1Cards(tmpList);
	}
}
