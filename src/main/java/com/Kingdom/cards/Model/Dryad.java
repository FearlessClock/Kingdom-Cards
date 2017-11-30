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
	
	public Dryad() {
		super();
		this.race = "Dryad";
	}

	public void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn) {
		if (playerTurn.equals(FieldController.PlayerTurn.player1)) {
			frame = new JFrame("Dryad Power");
			frame.setSize(1920, 1080);
			frame.setLocationByPlatform(true);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    
		    GridLayout gridL = new GridLayout();
		    gridL.setColumns(6);
		    gridL.setRows(1);
		    gridL.setHgap(5);
		    frame.setLayout(gridL);
		    
		    JButton jB = new JButton("card");
		    /*frame.getContentPane().add(new JButton("1"));
		    frame.getContentPane().add(new JButton("2"));
		    frame.getContentPane().add(new JButton("3"));
		    frame.getContentPane().add(new JButton("4"));
		    frame.getContentPane().add(new JButton("5"));*/
		    
		    
		    for (int i = 0; i < p2.hand.getHand().size(); i++) {
		    	jB = p2.hand.getHand().get(i).GetViewJ();
	            jB.addActionListener(this);
	            //jB.setDisabledSelectedIcon(false);
	            frame.getContentPane().add(jB);
	        }
		    frame.setVisible(true);
		    //JButton button = new JButton("Card");
		    
		    //frame.add(button);
		    
		    
	        
			
			
		}else if (playerTurn.equals(FieldController.PlayerTurn.playerAI)) {
			
			
			
		}        
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		System.out.println(button.getText());
		this.dispose();
		
	}
	
}


