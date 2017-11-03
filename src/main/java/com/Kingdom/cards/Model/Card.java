package com.Kingdom.cards.Model;

public class Card {
    String race;
    String name;

    public Card() {
        race = "Human";
    }

    public String GetRace(){
        return race;
    }

    public String GetName() {
    	return name;
	}

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if(obj.getClass() == this.getClass()) return true;
        else return false;
    }

    public void Power(){

    }
}
