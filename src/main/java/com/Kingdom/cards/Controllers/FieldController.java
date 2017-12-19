package com.Kingdom.cards.Controllers;

import com.Kingdom.cards.AI;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.GameState;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Player;
import com.Kingdom.cards.PlayerTurn;
import com.Kingdom.cards.View.FieldView;

import java.io.IOException;
import java.util.Random;

public class FieldController {

    /*
    * Kingdom cards! A card game about a growing population.
    * Generate a Deck, the deck contains 7 cards of each race.
    * Each plyer draws 1 card till both players have 5 cards.
    * Flip a coin to see who starts
    * The first player draws a card. He plays a card. Both are obligatory
    * The players turn then ends.
    * The game ends when all the cards are played.
    *
    * We will be using a sort of State machine to control the turns of each player.
    *
    * There are 3 states in the game:
    * 1) Init, shuffle and first 5 card draw
    * 2) Gameplay
    * 3) End game
    * */
    //The view part of the MVC build
    private FieldView fieldView;



    // The deck of cards
    private Deck deck;

    public Deck getDeck() {
        return deck;
    }

    // Board containing all the cards
    private Board board;

    public Board getBoard() {
        return board;
    }

    // Player1 object containing all the player data
    private Player player1 = new Player();

    public Player getPlayer1() {
        return player1;
    }

    private AI playerAI = new AI();//AI(board.getPlayerAICards(), board.getPlayer1Cards());

    public AI getPlayerAI() {
        return playerAI;
    }

    // Number of cards per player
    private int nmbrOfCardsInit = 5;
    private int nmbrOfCardsPerRace = 7;

    public PlayerTurn playerTurn;
    public boolean playerHasDrawn = false;
    public boolean playerHasPlay = false;

    private GameState gamestate;

    private PlayerTurn FlipACoin() {
        Random rand = new Random();
        boolean randomVal = rand.nextBoolean();
        if (randomVal)
            return PlayerTurn.player1;
        else
            return PlayerTurn.playerAI;
    }

    //Draw a card from the deck and add it to the player hand

    public FieldController(FieldView fieldView, PlayerTurn playerTurn) {
        this.fieldView = fieldView;
        gamestate = GameState.init;
        board = new Board();
        // Generate the deck of cards
        deck = new Deck(7);
        // Shuffle the deck of cards
        deck.Shuffle();

        for (int i = 0; i < nmbrOfCardsInit; i++) {
            player1.Draw(deck);
        }

        for (int i = 0; i < nmbrOfCardsInit; i++) {
            playerAI.Draw(deck);
        }

        if(playerTurn != null)
        {
            this.playerTurn = playerTurn;//FlipACoin();
        }
        else
        {
            this.playerTurn = FlipACoin();
        }

        gamestate = GameState.game;

        UpdateHands();
        UpdateBoard();

        if (this.playerTurn == PlayerTurn.playerAI) {
            turnOfAI();
        }

    }
    //Draw a card from the deck and add it to the player hand
    public void DrawCard() {
        if (!playerHasDrawn && playerTurn == PlayerTurn.player1) {
            Card card = player1.Draw(getDeck());
            playerHasDrawn = true;
            if(fieldView != null)
            {
                fieldView.AddCardToBoard(card, playerTurn);
            }
        }
    }

    //Send a card to the playing field and activate the power
    public void SendCard(int index) {
        if (!playerHasPlay) {
            if (playerTurn == PlayerTurn.player1) {
                Card playedCard = player1.hand.playCard(index);
                board.PlayCard(playedCard, deck, playerTurn, player1, playerAI);
            }
        }
        playerHasPlay = true;

        UpdateHands();
        UpdateBoard();

    }

    private void UpdateHands() {
        if(fieldView != null)
        {
            fieldView.UpdateHands(player1.hand, playerAI.hand);
        }
    }

    private void UpdateBoard() {
        if(fieldView != null)
        {
            fieldView.UpdateBoard(board);
        }
    }

    private void turnOfAI() {
        //Get fields cards
        playerAI.SetFields(board.getPlayerAICards(), board.getPlayer1Cards());
        
        playerHasDrawn = false;
        playerHasPlay = false;
        playerTurn = PlayerTurn.playerAI;

        // Draw Card
        Card c = playerAI.Draw(getDeck());
        playerHasDrawn = true;
        if(fieldView != null)
        {
            fieldView.AddCardToBoard(c, PlayerTurn.playerAI);
        }

        // Play Card
        Card playedCard = playerAI.PlayCard();
        board.PlayCard(playedCard, getDeck(), playerTurn, player1, playerAI);

        if(fieldView != null)
        {
            // Remove the card from the hand of the AI
            fieldView.RemoveCardFromHand(playedCard, PlayerTurn.playerAI);
        }

        // Update Board and variables
        playerHasPlay = true;
        UpdateHands();
        UpdateBoard();

        EndTurn();
    }

    // Callback for the end turn button
    public void EndTurn() {
        if (playerHasPlay || player1.hand.getNmbrOfCards() == 0) {
            // AI play
            if (playerTurn == PlayerTurn.player1) {
                turnOfAI();
                // Player play
            } else {
                playerHasDrawn = false;
                playerHasPlay = false;
                playerTurn = PlayerTurn.player1;

                if(fieldView != null)
                {
                    fieldView.GrayButtons(playerTurn);
                }
            }

            DrawCard();
            CheckEndGame();
        }
    }

    private void CheckEndGame() {
        int nmbrOfCardsInDeck = getDeck().Size();
        int player1NmbrOfCards = player1.hand.getNmbrOfCards();
        int playerAINmbrOfCards = playerAI.hand.getNmbrOfCards();

        if (nmbrOfCardsInDeck == 0 && (player1NmbrOfCards == 0 || playerAINmbrOfCards == 0)) {
            // Game is finished, show the end screen for win or lose
            boolean playerWin;
            playerWin = board.getPlayer1Score() > board.getPlayerAIScore();
            try {

                if(fieldView != null)
                {
                    fieldView.ShowEndScreen(playerWin);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
