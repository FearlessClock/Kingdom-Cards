package com.Kingdom.cards.Model;

import java.util.Scanner;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Model.Card;

public class Dryad extends Card{

	public Dryad(){
		super();
		this.race = "Dryad";
	}

	public String toString(){
		return ("You get a " + race + "\nPower : Steal a card in front of your opponent and add it in front of you without activating its power" );

	}
	public void power(int index, Board board, FieldController.PlayerTurn playerTurn){
		//Scanner sc = new Scanner(System.in);
		//index = sc.nextInt();
		board.PlayCard(board.RemoveCard(playerTurn, index), playerTurn);
		
	}

}
