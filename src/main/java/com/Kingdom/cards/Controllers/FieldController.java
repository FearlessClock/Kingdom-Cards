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
     * Kingdom cards! A card game about a growing population. Generate a Deck, the deck contains 7 cards of each race. Each plyer draws 1 card till both players have 5 cards. Flip a coin to see who starts The first player draws a card. He plays a card. Both are obligatory The players turn then ends. The game ends when all the cards are played.
     *
     * We will be using a sort of State machine to control the turns of each player.
     *
     * There are 3 states in the game: 1) Init, shuffle and first 5 card draw 2) Gameplay 3) End game
     */
    private FieldView fieldView;

    public FieldController(FieldView fieldView) {
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

        playerTurn = FlipACoin();

        gamestate = GameState.game;

        if (playerTurn == PlayerTurn.playerAI) {
            turnOfAI();
        }

    }

    // The deck of cards
    private Deck deck;

    public Deck GetDeck() {
        return deck;
    }

    // Board containing all the cards
    private Board board;

    public Board getBoard() {
        return board;
    }

    // Player
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

    public PlayerTurn playerTurn;
    private boolean playerHasDrawn = false;
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

    public void DrawCard() {
        if (!playerHasDrawn && playerTurn == PlayerTurn.player1) {
            Card card = player1.Draw(deck);
            playerHasDrawn = true;
            fieldView.AddCardToBoard(card, playerTurn);
        }
    }

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
        fieldView.UpdateHands(player1.hand, playerAI.hand);
    }

    private void UpdateBoard() {
        fieldView.UpdateBoard(board);
    }

    private void turnOfAI() {
        //Get fields cards
        playerAI.SetFields(board.getPlayerAICards(), board.getPlayer1Cards());
        
        playerHasDrawn = false;
        playerHasPlay = false;
        playerTurn = PlayerTurn.playerAI;

        // Draw Card
        Card c = playerAI.Draw(deck);
        playerHasDrawn = true;
        fieldView.AddCardToBoard(c, PlayerTurn.playerAI);

        // Play Card
        Card playedCard = playerAI.PlayCard();
        board.PlayCard(playedCard, deck, playerTurn, player1, playerAI);

        // Remove the card from the hand of the AI
        int playedCardIndex = -1;
        int nbOfCardInHand = playerAI.hand.getHand().size();

        fieldView.RemoveCardFromHand(playedCard, PlayerTurn.playerAI);

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
                fieldView.GrayButtons(playerTurn);
            }

            DrawCard();
            CheckEndGame();
        }
    }

    private void CheckEndGame() {
        int nmbrOfCardsInDeck = deck.Size();
        int player1NmbrOfCards = player1.hand.getNmbrOfCards();
        int playerAINmbrOfCards = playerAI.hand.getNmbrOfCards();

        if (nmbrOfCardsInDeck == 0 && (player1NmbrOfCards == 0 || playerAINmbrOfCards == 0)) {
            // Game is finished, show the end screen for win or lose
            boolean playerWin;
            playerWin = board.getPlayer1Score() > board.getPlayerAIScore();
            try {
                fieldView.ShowEndScreen(playerWin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
