package com.Kingdom.cards;

public class Card {
    String race;
    String Name;

    public Card() {
        race = "Human";
    }

    public String GetRace(){
        return race;
    }
    
    public String GetName() {
    	return Name;
	}
    
    @Override
    public String toString(){
    	return Name;
    }
}
