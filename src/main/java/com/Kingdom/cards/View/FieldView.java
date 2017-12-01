package com.Kingdom.cards.View;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Card;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FieldView {

    // Labels showing the number of cards per person
    @FXML
    private Label nmbrOfCardsPlayer1;
    @FXML
    private Label nmbrOfCardsPlayerAI;

    @FXML
    public void initialize() {
        gamestate = FieldController.GameState.init;
        board = new Board();
        // Generate the deck of cards
        deck = new Deck(7);
        // Shuffle the deck of cards
        deck.Shuffle();

        if (nmbrOfCardsPlayer1 != null) {
            nmbrOfCardsPlayer1.textProperty().bind(board.player1ScoreStr);
        }
        if (nmbrOfCardsPlayerAI != null) {
            nmbrOfCardsPlayerAI.textProperty().bind(board.playerAIScoreStr);
        }

        Card c;
        Button b;
        for (int i = 0; i < nmbrOfCardsInit; i++) {
            c = player1.Draw(deck);
            if(c != null)
            {
                b = c.GetView();
                b.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        SendCard(event);
                    }
                });
                player1Field.getChildren().add(b);
            }
        }
        for (int i = 0; i < nmbrOfCardsInit; i++) {
            c = playerAI.Draw(deck);
            if(c != null)
            {
                b = c.GetView();
                b.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        SendCard(event);
                    }
                });
                playerAIField.getChildren().add(b);
            }
        }

        playerTurn = FlipACoin();

        GrayButtons(player1Field.getChildren(), playerAIField.getChildren(), playerTurn);

        gamestate = FieldController.GameState.game;

        if (playerTurn == FieldController.PlayerTurn.playerAI) {
            turnOfAI();
        }
    }
}
