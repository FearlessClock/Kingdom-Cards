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
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if(obj.getClass() == this.getClass()) return true;
        else return false;
    }
}
