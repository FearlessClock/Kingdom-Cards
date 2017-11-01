package com.Kingdom.cards;

public class Card {
    String race;
    String name;

    public Card() {
        race = "Human";
    }

    public String GetRace(){
        return race;
    }
    
    public String Getname() {
    	return name;
	}
    
    @Override
    public String toString(){
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
