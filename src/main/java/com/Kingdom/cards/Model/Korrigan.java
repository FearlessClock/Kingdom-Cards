package com.Kingdom.cards.Model;

import com.Kingdom.cards.Model.Card;

import java.util.ArrayList;
import java.util.List;

public class Korrigan extends Card {
	public Korrigan() {
		super();
		this.race = "Korrigan";
	}
	public void Power(){
		/*for (int i = 0 ; i < 2 ; i++){
=======
	public void Power(List<Card> opponentHand, List<Card> ourHand) {
		for (int i = 0; i < 2; i++) {
>>>>>>> master
			int cardPos = (int) (Math.random() * opponentHand.size());
			ourHand.add(opponentHand.get(cardPos));
			opponentHand.remove(cardPos);
		}*/
		
	}
	@Override
	public void Power(Board b, Hand AIHand, Hand playerHand) {
		// TODO Auto-generated method stub
		
	}
}
