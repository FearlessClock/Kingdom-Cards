package com.Kingdom.cards.Controllers;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;


public class FieldController {

	/*
    * Kingdom cards! A card game about a growing population.
	* Generate a Deck, the deck contains 8 cards of each race.
	* Each player draws 1 card till both players have 5 cards.
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

	//The horizontal box
    @FXML
    HBox player1Field;
    @FXML
    HBox player2Field;

    //The deck of cards
    Deck deck;

    //Board containing all the cards
    Board board;

    //Player 1
    Player player1 = new Player();
    Player player2 = new Player();

    //Number of cards per player
    int nmbrOfCardsInit = 5;


    //Player turn state variable
    public enum PlayerTurn {
        player1, player2
    }

    PlayerTurn playerTurn;
    boolean playerHasDrawn = false;

    //The state of the game, where we are.
    public enum GameState {
        init, game, end
    }

    GameState gamestate;

    //Labels showing the number of cards per person
    @FXML
    private Label nmbrOfCardsPlayer1;
    @FXML
    private Label nmbrOfCardsPlayer2;

    @FXML
    public void initialize() {
        gamestate = GameState.init;
        board = new Board();
        //Generate the deck of cards
        deck = new Deck(8);
        //Shuffle the deck of cards
        deck.Shuffle();

        nmbrOfCardsPlayer1.textProperty().bind(player1.hand.nmbrOfCardsStrProperty);
        nmbrOfCardsPlayer2.textProperty().bind(player2.hand.nmbrOfCardsStrProperty);

        for (int i = 0; i < nmbrOfCardsInit; i++) {
            player1.Draw(deck);
            player2.Draw(deck);
        }

        playerTurn = FlipACoin();
        gamestate = GameState.game;
       /* //Start game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(gamestate == GameState.game)
                {

                }
            }
        }.start();*/
    }

    private PlayerTurn FlipACoin() {
        Random rand = new Random();
        boolean randomVal = rand.nextBoolean();
        if (randomVal)
            return PlayerTurn.player1;
        else
            return PlayerTurn.player2;
    }

    public void DrawCard(ActionEvent event) {
        if (!playerHasDrawn && playerTurn == PlayerTurn.player1) {
            player1.Draw(deck);
            playerHasDrawn = true;
        } else if (!playerHasDrawn && playerTurn == PlayerTurn.player2) {
            player2.Draw(deck);
            playerHasDrawn = true;
        }
    }

    public void SendCard(ActionEvent event) {
        Button button = (Button) event.getSource();
        String id = (button).getId();
        int idInt = Integer.parseInt(id.split("p")[0]);

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        if (playerTurn == PlayerTurn.player1) {
            Card playedCard = player1.hand.PlayCard(idInt);
            board.PlayCard(playedCard, playerTurn);
            player1Field.getChildren().remove(button);
        } else {
            Card playedCard = player2.hand.PlayCard(idInt);
            board.PlayCard(playedCard, playerTurn);
            player2Field.getChildren().remove(button);
        }
    }

    public void EndTurn(ActionEvent actionEvent) {
        if(playerTurn == PlayerTurn.player1)
        {
            playerHasDrawn = false;
            playerTurn = PlayerTurn.player2;
        }
        else
        {
            playerHasDrawn = false;
            playerTurn = PlayerTurn.player1;
        }
    }

}
