package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;

public class Gnome extends Card
{
    public Gnome() {
        super();
        this.race = "Gnome";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn, FieldView fieldView) {
        // Draw two times using the draw function
        p1.Draw(d);
        p1.Draw(d);
    }
}
