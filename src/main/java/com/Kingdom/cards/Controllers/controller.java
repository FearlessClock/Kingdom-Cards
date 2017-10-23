package com.Kingdom.cards.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controller {
	
	@FXML
	Button btnDraw;
	
	public void DrawCard(ActionEvent event){
		System.out.println("Card draw");
	}
}
