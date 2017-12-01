package com.Kingdom.cards.Controllers;

import com.Kingdom.cards.AI;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Player;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Random;


public class FieldController {

	/*
    * Kingdom cards! A card game about a growing population.
	* Generate a Deck, the deck contains 7 cards of each race.
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

    // The horizontal box
    @FXML
    HBox player1Field;
    @FXML
    HBox playerAIField;

    @FXML
    HBox player1Board;
    @FXML
    HBox playerAIBoard;

    @FXML
    Label turnLbl;

    @FXML
    Button btnEndTurn;

    //The deck of cards
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

    private AI playerAI = new AI();

    public AI getPlayerAI() {
        return playerAI;
    }

    // Number of cards per player
    private int nmbrOfCardsInit = 5;

    @FXML
    public void keyPressed(KeyEvent keyEvent) throws IOException {
        Scene par = (((AnchorPane) keyEvent.getSource()).getScene());
        switch (keyEvent.getCode()) {
            case ESCAPE:
                int maxWidth = 128;
                int maxHeight = 128;
                Window window = ((AnchorPane) keyEvent.getSource()).getScene().getWindow();
                final Popup popup = new Popup();
                popup.setX(window.getWidth() / 2);
                popup.setY(window.getHeight() / 2);

                Button quit = new Button("Quit");
                quit.setPrefSize(maxWidth, 64);
                Button resume = new Button("Resume");
                resume.setPrefSize(maxWidth, 64);

                quit.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        Platform.exit();
                    }
                });

                resume.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        popup.hide();
                    }
                });

                VBox box = new VBox();
                box.setPrefSize(maxWidth, maxHeight);
                box.setStyle("-fx-background-image: url('fxml/ingameMenuBackground.png'); " +
                        "-fx-background-position: center center; " +
                        "-fx-background-repeat: stretch;");
                box.getChildren().addAll(resume, quit);

                popup.getContent().add(box);
                popup.show(window);
                break;
        }
    }
    
    @FXML
    public void MoveScreen(KeyEvent keyEvent) throws IOException {
    	Window window = ((AnchorPane) keyEvent.getSource()).getScene().getWindow();
        final Popup popup = new Popup();
        popup.setX(window.getX() / 2);
        popup.setY(window.getY() / 2);
    	
    }
    

    // Player turn state variable
    public enum PlayerTurn {
        player1, playerAI
    }

    private PlayerTurn playerTurn;
    private boolean playerHasDrawn = false;
    private boolean playerHasPlay = false;

    // The state of the game, where we are.
    public enum GameState {
        init, game, end
    }

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
            Card c = player1.Draw(deck);
            playerHasDrawn = true;
            if (c != null) {
                Button b = c.GetView();
                b.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        SendCard(event);
                    }
                });
                player1Field.getChildren().add(b);
            }
        }
    }

    private void SendCard(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (!playerHasPlay) {
            if (playerTurn == PlayerTurn.player1) {
                Card playedCard = player1.hand.playCard(button.getParent().getChildrenUnmodifiable().indexOf(button));
                board.PlayCard(playedCard, deck, playerTurn, player1, playerAI);
                player1Field.getChildren().remove(button);
            }
        }

        playerHasPlay = true;

        UpdateHands();
        UpdateBoard();

        GrayButtons(player1Field.getChildren(), playerAIField.getChildren(), playerTurn);
    }

    private void UpdateHands() {
        player1Field.getChildren().clear();
        playerAIField.getChildren().clear();
        Button b;
        for (int i = 0; i < player1.hand.getHand().size(); i++) {
            b = player1.hand.getHand().get(i).GetView();
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    SendCard(event);
                }
            });
            b.setDisable(false);
            player1Field.getChildren().add(b);
        }
        for (int i = 0; i < playerAI.hand.getHand().size(); i++) {
            b = playerAI.hand.getHand().get(i).GetView();
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    SendCard(event);
                }
            });
            b.setDisable(false);
            playerAIField.getChildren().add(b);
        }
    }

    private void UpdateBoard() {
        player1Board.getChildren().clear();
        playerAIBoard.getChildren().clear();
        Button b;
        for (int i = 0; i < board.getPlayer1Cards().size(); i++) {
            b = board.getPlayer1Cards().get(i).GetView();
            b.setDisable(true);
            player1Board.getChildren().add(b);
        }
        for (int i = 0; i < board.getPlayerAICards().size(); i++) {
            b = board.getPlayerAICards().get(i).GetView();
            b.setDisable(true);
            playerAIBoard.getChildren().add(b);
        }
    }

    private void GrayButtons(ObservableList<Node> p1, ObservableList<Node> p2, PlayerTurn pt) {
        if (pt == PlayerTurn.player1) {
            for (Node b : p1) {
                b.setDisable(false);
                b.setOpacity(1);
            }
            for (Node b : p2) {
                b.setDisable(true);
                b.setOpacity(0.5);
            }
        } else {
            for (Node b : p2) {
                b.setDisable(true);
                b.setOpacity(0.5);
            }
            for (Node b : p1) {
                b.setDisable(true);
                b.setOpacity(0.5);
            }
        }
    }

    public void turnOfAI() {
        playerHasDrawn = false;
        playerHasPlay = false;
        playerTurn = PlayerTurn.playerAI;

        // Draw Card
        Card c = playerAI.Draw(deck);
        playerHasDrawn = true;
        if (c != null) {
            Button b = c.GetView();
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    SendCard(event);
                }
            });
            playerAIField.getChildren().add(b);
        }

        // Play Card
        Card playedCard = playerAI.PlayCard();
        board.PlayCard(playedCard, deck, playerTurn, player1, playerAI);

        // Remove the card from the hand of the AI
        int playedCardIndex = -1;
        int nbOfCardInHand = playerAIField.getChildren().size();
        for (int i = 0; i < nbOfCardInHand; i++) {
            Button buti = (Button) playerAIField.getChildren().get(i);

            if (buti.textProperty().getValue() == playedCard.GetRace()) {
                playedCardIndex = i;
                break;
            }
        }
        if(playedCardIndex >= 0)
        {
            playerAIField.getChildren().remove(playedCardIndex);
        }

        // Update Board and variables
        playerHasPlay = true;
        UpdateHands();
        UpdateBoard();

        EndTurn();
    }

    public void EndTurn() {
        if (playerHasPlay || player1.hand.getNmbrOfCards() == 0) {
            ObservableList<Node> buttonsP1 = player1Field.getChildren();
            ObservableList<Node> buttonsP2 = playerAIField.getChildren();
            //AI play
            if (playerTurn == PlayerTurn.player1) {
                turnOfAI();
                //Player play
            } else {
                playerHasDrawn = false;
                playerHasPlay = false;
                playerTurn = PlayerTurn.player1;
                GrayButtons(buttonsP1, buttonsP2, playerTurn);
            }
            turnLbl.setText(playerTurn.toString());
            DrawCard();
            try {
                CheckEndGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void CheckEndGame() throws IOException {
        int nmbrOfCardsInDeck = deck.Size();
        int player1NmbrOfCards = player1.hand.getNmbrOfCards();
        int playerAINmbrOfCards = playerAI.hand.getNmbrOfCards();

        if (nmbrOfCardsInDeck == 0 && (player1NmbrOfCards == 0 || playerAINmbrOfCards == 0)) {
            //Game is finished, show the end screen for win or lose
            if (board.getPlayer1Score() > board.getPlayerAIScore()) {
                //Show win screen
                Stage stage = (Stage) player1Field.getScene().getWindow();
                Parent winScene = FXMLLoader.load(getClass().getResource("/fxml/WinView.fxml"));
                Scene scene = new Scene(winScene);
                if(stage != null)
                {
                    stage.setScene(scene);
                    stage.setFullScreen(true);
                    stage.show();
                }
            } else {
                //Show lose screen
                Stage stage = (Stage) player1Field.getScene().getWindow();
                Parent winScene = FXMLLoader.load(getClass().getResource("/fxml/EndView.fxml"));
                Scene scene = new Scene(winScene);
                if(stage != null)
                {
                    stage.setScene(scene);
                    stage.setFullScreen(true);
                    stage.show();
                }
            }
        }
    }
}
