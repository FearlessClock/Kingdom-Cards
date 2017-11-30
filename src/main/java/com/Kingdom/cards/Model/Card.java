package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.Kingdom.cards.Deck;
import javafx.scene.control.Button;

public abstract class Card extends JFrame implements ActionListener{
    protected String race;

    public Card() {
        race = "Human"; // default race
    }

    public String GetRace() {
        return race;
    }

    public Button GetView() {

        Button view = new Button();
        view.setMinWidth(150);
        view.setMinHeight(150);
        view.getStyleClass().add(race.toLowerCase());
        view.getStylesheets().add("@Cards.css");
        return view;
    }
    
    public JButton GetViewJ() {

        JButton view = new JButton(race.toLowerCase());
        //view.setSize(10, 10);
        
        
        //view.setName(race.toLowerCase());
        //view.setIcon(new ImageIcon("@Cards.css"));
        //view.getStylesheets().add("@Cards.css");
        return view;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        return obj.getClass() == this.getClass();
    }

    public abstract void power(Board b, Deck d, Player p1, Player p2, FieldController.PlayerTurn playerTurn);

}
