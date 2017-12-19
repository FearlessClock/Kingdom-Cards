package com.Kingdom.cards.Features;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Gnome;
import com.Kingdom.cards.Model.Player;
import com.Kingdom.cards.PlayerTurn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GnomeStep {

    private Player player1;
    private Player playerAI;
    private Deck deck;
    private Board board;


    @Given("^A deck with (\\d+) cards$")
    public void a_deck_with_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        deck = new Deck(1);    //Gives me a deck of 6 cards
        player1 = new Player();
        playerAI = new Player();
        for (int i = 0; i < 6 - arg1; i++) {    //Make my deck have arg1 amount of cards
            playerAI.Draw(deck);
        }

        board = new Board();
    }

    @When("^I play a Gnome card$")
    public void i_play_a_Gnome_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        board.PlayCard(new Gnome(), deck, PlayerTurn.player1, player1, playerAI, null);
    }

    @Then("^My hand has (\\d+) more cards$")
    public void my_hand_has_more_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertEquals(arg1, player1.hand.getNmbrOfCards());
    }


}
