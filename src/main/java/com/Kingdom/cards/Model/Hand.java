package com.Kingdom.cards.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Hand {

    List<Card> hand = new ArrayList<Card>();
    IntegerProperty nmbrOfCardsProperty = new SimpleIntegerProperty(0);

    public int getNmbrOfCards() {
        return nmbrOfCardsProperty.get();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> cards) {
        hand = cards;
        nmbrOfCardsProperty.set(hand.size());
    }

    public Hand() {

    }

    public void addToHand(Card card) {
        hand.add(card);
        nmbrOfCardsProperty.set(nmbrOfCardsProperty.get() + 1);
    }

    public Card removeFromHand(int index) {
        Card card = hand.get(index);
        hand.remove(index);
        nmbrOfCardsProperty.set(nmbrOfCardsProperty.get() - 1);
        return card;
    }

    public Card playCard(int index) {
        Card played;
        if (hand.size() > index) {
            played = hand.get(index);
            removeFromHand(index);
        } else {
            //TODO This is not good! Make it never crash
            ///Quick fix
            played = hand.get(hand.size() - 1);
            hand.remove(hand.size() - 1);
            return played;

        }
        return played;
    }

    public int selectCard() {
        return Integer.parseInt((JOptionPane.showInputDialog(" Choisissez une carte entre 1 et "+getNmbrOfCards())))-1;
    }
}
