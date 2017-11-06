package com.Kingdom.cards.Model;

import java.util.ArrayList;
import java.util.List;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Model.Card;

public class Troll extends Card {

	public Troll(){
		super();
		this.name = "Troll";
	}

	public void Power(Board board, FieldController.PlayerTurn playerTurn){
		List<Card> tmpCards = new ArrayList<Card>();
		int i = 0;
		while (!board.IsEmpty(playerTurn)){ // To save the board of the player
			tmpCards.add(board.RemoveCard(playerTurn, i));
			i++;
		}
		
		int j = 0;
		if (FieldController.PlayerTurn.player1 == playerTurn){ // Put the card of the opponent in front of you
			while (!board.IsEmpty(FieldController.PlayerTurn.player2)){
				board.PlayCard(board.RemoveCard(FieldController.PlayerTurn.player2, j), playerTurn);
				j++;
			}
		}
		
		else{
			while (!board.IsEmpty(FieldController.PlayerTurn.player1)){
				board.PlayCard(board.RemoveCard(FieldController.PlayerTurn.player1, j), playerTurn);
				j++;
			}
		}
		
		
	}
}
