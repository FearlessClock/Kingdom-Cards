package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Card> player1Cards;
    private List<Card> player2Cards;


    public Board() {
        player1Cards = new ArrayList<Card>();
        player2Cards = new ArrayList<Card>();
    }

    public void PlayCard(Card card, FieldController.PlayerTurn playerTurn) {
        if (FieldController.PlayerTurn.player1 == playerTurn) {
            player1Cards.add(card);
        } else {
            player2Cards.add(card);
        }
    }
    
    public Card RemoveCard(FieldController.PlayerTurn playerTurn, int index){ // Remove a card from the player board
    	Card removedCard = new Card();
    	switch(playerTurn){
    	case player1 :
    		removedCard = player2Cards.remove(index);
    		break;
		case player2 :
    		removedCard = player1Cards.remove(index);
    		break;
		default:
    		System.out.println("Wrong player number");
    		break;
    	}
    	return removedCard;
    }
    
    public Boolean IsEmpty(FieldController.PlayerTurn playerTurn){
    	Boolean isEmpty = false;
    	switch (playerTurn){
    	case player1 :
    		if (player1Cards.size() == 0){
    			isEmpty = true;
    		}
    		break;
    	case player2 :
    		if (player2Cards.size() == 0){
    			isEmpty = true;
    		}
    		break;
    	default:
    		System.out.println("Wrong player number");
    		break;
    	}
    	return isEmpty;
    }
    
    

}
