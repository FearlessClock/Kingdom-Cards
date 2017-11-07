package com.Kingdom.cards.Model;

import com.Kingdom.cards.Deck;

public class Player {

    protected String pseudo;
    public Hand hand;

    public Player() {
        hand = new Hand();
    }

    public Player(String pseudo) {
        this.pseudo = pseudo;
        hand = new Hand();
    }

    public Card Draw(Deck deck) {
        Card c = deck.GetFirstCard();
        hand.AddToHand(c);
        return c;
    }

    public int SizeHand() {
        return hand.nmbrOfCardsProperty.get();
    }

    public Card PlayCard(int cardIndex) {
        return hand.PlayCard(cardIndex);
    }
}
