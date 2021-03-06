package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;
import javafx.scene.control.Button;

public abstract class Card {
    protected String race;

    // Constructor
    public Card() {
        race = "Human"; // Default race
    }

    // Get
    public String GetRace() {
        return race;
    }

    public Button GetView(Boolean isAI) {
        Button view = new Button();
        view.setMinWidth(50);
        view.setMinHeight(50);
        view.getStyleClass().add(race.toLowerCase());
        if (isAI) {
            view.getStyleClass().add("verso");
        }
        view.getStylesheets().add("@Cards.css");
        return view;
    }

    // Override
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return obj.getClass() == this.getClass();
    }

    public abstract void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn, FieldView fieldView);

}
