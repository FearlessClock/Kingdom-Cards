package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Card> player1Cards;
    private List<Card> playerAICards;

    private IntegerProperty player1Score = new SimpleIntegerProperty(0);
    public StringProperty player1ScoreStr = new SimpleStringProperty("0");

    private IntegerProperty playerAIScore = new SimpleIntegerProperty(0);
    public StringProperty playerAIScoreStr = new SimpleStringProperty("0");


    public Board() {
        player1Cards = new ArrayList<Card>();
        playerAICards = new ArrayList<Card>();
        player1Score.addListener(changeListener);
        playerAIScore.addListener(changeListener);
    }

    public int getPlayer1Score() {
        return player1Score.get();
    }

    public int getPlayerAIScore() {
        return playerAIScore.get();
    }

    public List<Card> getPlayer1Cards() {
        return player1Cards;
    }

    public void setPlayer1Cards(List<Card> cards) {
        player1Cards = cards;
    }

    public void setPlayerAICards(List<Card> cards) {
        playerAICards = cards;
    }

    public List<Card> getPlayerAICards() {
        return playerAICards;
    }
    
    public void addCard(Card card, PlayerTurn playerTurn){
    	if (card != null) {
            if (PlayerTurn.player1 == playerTurn) {
            	player1Cards.add(card);
            } else { 
            	playerAICards.add(card);
            }
        }
    }
    
    public void removeCard(Card card, PlayerTurn playerTurn){
    	if (card != null) {
            if (PlayerTurn.player1 == playerTurn) {
            	playerAICards.remove(card);
            } else { 
            	player1Cards.remove(card);
            }
        }
    }
    
    public Card getCard(int index, PlayerTurn playerTurn){
    	Card chosenCard;
    	if (PlayerTurn.player1 == playerTurn) {
        	chosenCard = playerAICards.get(index);
        } else { 
        	chosenCard = player1Cards.get(index);
        }
    	
    	return chosenCard;
    }

    
    //Play the chosen card for the current playerturns player
    public void PlayCard(Card card, Deck deck, PlayerTurn playerTurn, Player p1, Player p2) {
        if (card != null) {
            if (PlayerTurn.player1 == playerTurn) {
            	card.power(this, deck, p1, p2, playerTurn);
                player1Cards.add(card);
                GetScorePlayer(1);
            } else { 
                card.power(this, deck, p2, p1, playerTurn);
                playerAICards.add(card);
                GetScorePlayer(2);
            }
        }
    }

    private final ChangeListener changeListener = new ChangeListener() {
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            player1ScoreStr.set(Integer.toString(getPlayer1Score()));
            playerAIScoreStr.set(Integer.toString(getPlayerAIScore()));
        }
    };

    private int GetScorePlayer(int player) {
        List<Card> playerboard = new ArrayList<Card>();
        if (player == 1) {
            playerboard.addAll(player1Cards);
        } else if (player == 2) {
            playerboard.addAll(playerAICards);
        }
        int score = playerboard.size();
        List<Integer> listingClass = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            listingClass.add(i, 0);
        }
        for (Card c : playerboard) {
            if ("Dryad".equals(c.GetRace())) {
                listingClass.set(0, listingClass.get(0) + 1);
            }
            if ("Elf".equals(c.GetRace())) {
                listingClass.set(1, listingClass.get(1) + 1);
            }
            if ("Gnome".equals(c.GetRace())) {
                listingClass.set(2, listingClass.get(2) + 1);
            }
            if ("Goblin".equals(c.GetRace())) {
                listingClass.set(3, listingClass.get(3) + 1);
            }
            if ("Korrigan".equals(c.GetRace())) {
                listingClass.set(4, listingClass.get(4) + 1);
            }
            if ("Troll".equals(c.GetRace())) {
                listingClass.set(5, listingClass.get(5) + 1);
            }
        }
        int mini = listingClass.get(0);
        for (int i : listingClass) {
            if (i < mini) {
                mini = i;
            }
        }
        score += mini * 3;
        if (player == 1) {
            player1Score.set(score);
        } else if (player == 2) {
            playerAIScore.set(score);
        }
        return score;
    }

}
