package com.Kingdom.cards.Model;

import java.util.Random;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Card;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import com.Kingdom.cards.PlayerTurn;

public class Dryad extends Card
{

    Card chosenCard;
    Stage stage = new Stage();
    Button card;

    public Dryad()
    {
        super();
        this.race = "Dryad";
    }

    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn)
    {
        // If it's the human player whom play
        if (playerTurn.equals(PlayerTurn.player1))
        {
            if (b.getPlayerAICards().size() > 0)// Check if there is cards in the opponent field
            {
                VBox root = new VBox(b.getPlayerAICards().size() + 10);// Create a new VBox
                Label modalityLabel = new Label("Choose a card");//Create a new label to display what the player have to do
                root.getChildren().add(modalityLabel);

                // For every cards in the opponent's field
                for (int i = 0; i < b.getPlayerAICards().size(); i++)
                {
                    card = new Button(b.getPlayerAICards().get(i).GetRace());// Create a button for each card in the opponent's field
                    root.getChildren().add(card);// Add card to the VBox
                    card.setOnAction(e -> actionPerformed(e, b, playerTurn));// When clicked
                }
                // Create the new scene and display it
                Scene scene = new Scene(root, 500, 500);
                stage.setScene(scene);
                stage.show();
            }
        }
        // If it's the AI turn
        else if (playerTurn.equals(PlayerTurn.playerAI))
        {
            if (b.getPlayer1Cards().size() > 0)// Check if there is cards in the opponent field
            {
                Random rand = new Random();
                int randVal = rand.nextInt(b.getPlayer1Cards().size());// Random choose a card in the opponent's field

                // Add the card chosen to the AI field and remove it from the player's field
                b.addCard(b.getCard(randVal, playerTurn), playerTurn);
                b.removeCard(b.getCard(randVal, playerTurn), playerTurn);
            }
        }
    }

    public void actionPerformed(ActionEvent e, Board b, PlayerTurn playerTurn)
    {

        Button button = (Button) e.getSource();
        String race = button.getText();// Get the race of the button the player clicked on

        // Cases depending on the card clicked
        if ("Troll".equals(race))
        {
            chosenCard = new Troll();
        }

        else if ("Korrigan".equals(race))
        {
            chosenCard = new Korrigan();
        }

        else if ("Goblin".equals(race))
        {
            chosenCard = new Goblin();
        } else if ("Elf".equals(race))
        {
            chosenCard = new Elf();
        }

        else if ("Dryad".equals(race))
        {
            chosenCard = new Dryad();
        }

        else if ("Gnome".equals(race))
        {
            chosenCard = new Gnome();
        }

        if (chosenCard != null)
        {
            // Add the card chosen to the player's field and remove it from the AI field
            b.addCard(chosenCard, playerTurn);
            b.removeCard(chosenCard, playerTurn);
        }
        // Close the stage
        stage.close();
    }
}
