package com.Kingdom.cards.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class Hand {

    List<Card> hand = new ArrayList<Card>();
    IntegerProperty nmbrOfCardsProperty = new SimpleIntegerProperty(0);
    
    public int GetNmbrOfCards()
    {
        return nmbrOfCardsProperty.get();
    }

    public List<Card> getHand()
    {
        return hand;
    }

    public void setHand(List<Card> cards)
    {
        hand = cards;
    }

    public Hand() {
        
    }

    public void AddToHand(Card card) {
        hand.add(card);
        nmbrOfCardsProperty.set(nmbrOfCardsProperty.get() + 1);
    }

    public Card PlayCard(int index) {
        Card played;
        if(hand.size() > index)
        {
            played = hand.get(index);
            hand.remove(index);
            nmbrOfCardsProperty.set(nmbrOfCardsProperty.get() - 1);
        }
        else
        {
            played = null;
        }
        return played;
    }

}
