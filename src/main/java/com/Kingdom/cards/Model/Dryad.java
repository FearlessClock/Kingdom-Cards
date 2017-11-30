package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Window;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.AsyncBoxView.ChildState;

public class Dryad extends Card{

	JFrame frame;
	Card chosenCard;
	
	public Dryad() {
		super();
		this.race = "Dryad";
	}

	public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
		if (playerTurn.equals(FieldController.PlayerTurn.player1)) {
			frame = new JFrame("Dryad Power");
			frame.setSize(1620, 780);
			frame.setLocationByPlatform(true);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    
		    GridLayout gridL = new GridLayout();
		    gridL.setColumns(6);
		    gridL.setRows(1);
		    gridL.setHgap(5);
		    frame.setLayout(gridL);
		    
		    JButton jB = new JButton("card");
		   
		    for (int i = 0; i < b.getPlayerAICards().size(); i++) {
		    	jB = b.getPlayerAICards().get(i).GetViewJ();
	            jB.addActionListener(this);
	            
	            frame.getContentPane().add(jB);
	        }
  
		    frame.setVisible(true);
		    
		    /*while (chosenCard == null){
		    	
		    }*/
			b.addPlayer1Card(chosenCard);
			

			
		}else if (playerTurn.equals(FieldController.PlayerTurn.playerAI)) {
			
			
			
		}        
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		System.out.println(button.getText());
		switch (button.getText()){
		case "Troll":
			chosenCard = new Troll();
			break;
		case "Korrigan":
			chosenCard = new Korrigan();
			break;
		case "Goblin":
			chosenCard = new Goblin();
			break;
		case "Elf":
			chosenCard = new Elf();
			break;
		case "Dryad":
			chosenCard = new Dryad();
			break;
		case "Gnome":
			chosenCard = new Gnome();
			break;
		default:
			break;
		}
		
		frame.dispose();
		
	}
	
}


