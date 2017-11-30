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

public class Dryad extends Card {

	public Dryad() {
		super();
		this.race = "Dryad";
	}

	public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
		if (playerTurn.equals(FieldController.PlayerTurn.player1)) {
			final JFrame frame = new JFrame("Dryad Power");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300, 300);
			frame.setLocationByPlatform(true);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    
		    GridLayout gridL = new GridLayout();
		    gridL.setColumns(6);
		    gridL.setRows(1);
		    gridL.setHgap(5);
		    frame.setLayout(gridL);
		    
		    
		    frame.getContentPane().add(new JButton("1"));
		    frame.getContentPane().add(new JButton("2"));
		    frame.getContentPane().add(new JButton("3"));
		    frame.getContentPane().add(new JButton("4"));
		    frame.getContentPane().add(new JButton("5"));
		    frame.setVisible(true);
		    
		    //JButton button = new JButton("Card");
		    
		    //frame.add(button);
		    
		    

		    //frame.dispose();
	        
			
			
		}else if (playerTurn.equals(FieldController.PlayerTurn.playerAI)) {
			
			
			
		}
		
		
        
	}
	
}


