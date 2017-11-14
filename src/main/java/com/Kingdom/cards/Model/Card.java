package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;
import javafx.scene.control.Button;

public abstract class Card {
    protected String race;
    protected String name;
    protected Button view;

	public Card() {
		race = "Human"; // default race
		view=new Button();
		view.setMinWidth(150);
	    view.setMinHeight(150);
	}

	public String GetRace() {
		return race;
	}

	public String GetName() {
		return name;
	}
    public Button GetView(){
	    return view;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        return obj.getClass() == this.getClass();
    }

    public abstract void power(Board b, Deck d, Player p1, Player p2);

}
