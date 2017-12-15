package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import javafx.scene.control.Button;

public abstract class Card {
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

    public abstract void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn);

}
