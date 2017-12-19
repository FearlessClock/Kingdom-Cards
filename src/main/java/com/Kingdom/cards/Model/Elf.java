package com.Kingdom.cards.Model;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.PlayerTurn;

public class Elf extends Card
{

    Card chosenCard;
    Stage stage = new Stage();
    Button card;

    // Constructor
    public Elf()
    {
        super();
        this.race = "Elf";

    }

    // Functions
    public void power(Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn)
    {
        // If it's the human player whom play
        if (playerTurn.equals(PlayerTurn.player1))
        {
            if (b.getPlayer1Cards().size() > 0)// Check if there is cards in the player field
            {
                stage.initModality(Modality.APPLICATION_MODAL);

                VBox root = new VBox(b.getPlayer1Cards().size() + 10);// Create a new VBox
                Label modalityLabel = new Label("Choose a card");// Create a new label to display what the player have to do
                root.getChildren().add(modalityLabel);// Add the label to the VBox

                // For every cards in the player's field
                for (int i = 0; i < b.getPlayer1Cards().size(); i++)
                {
                    if (!"Elf".equals(b.getPlayer1Cards().get(i).GetRace()))// Check if the card isn't an elf
                    {
                        card = new Button(b.getPlayer1Cards().get(i).GetRace());// Create a button for each card in the player's field
                        root.getChildren().add(card);// Add card to the VBox
                        card.setOnAction(e -> actionPerformed(e, b, d, p1, p2, playerTurn));// When clicked
                    }
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
            if (b.getPlayerAICards().size() > 0)// Check if there is cards in the AI field
            {
                // Initialize radom
                Random rand = new Random();
                int randVal;
                do
                {
                    randVal = rand.nextInt(b.getPlayer1Cards().size());// Choose a random card in the AI field
                } while ("Elf".equals(b.getCard(randVal, playerTurn).GetRace()));// Check if the chosen card isn't an elf

                // Add the card to the Ai's hand and remove it so it plays the power
                b.addCard(b.getCard(randVal, playerTurn), playerTurn);
                b.removeCard(b.getCard(randVal, playerTurn), playerTurn);
            }
        }
    }

    public void actionPerformed(ActionEvent e, Board b, Deck d, Player p1, Player p2, PlayerTurn playerTurn)
    {
        // See the button click
        Button button = (Button) e.getSource();
        String race = button.getText();// Get the race of the clicked button

        // Create a card depending of the button clicked
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
        }

        else if ("Elf".equals(race))
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
            // Play the function to activate the poser of the card
            chosenCard.power(b, d, p1, p2, playerTurn);
        }

        // Close the stage
        stage.close();
    }

}
