package com.Kingdom.cards.Features;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Goblin;
import com.Kingdom.cards.Model.Player;
import com.Kingdom.cards.PlayerTurn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GoblinStep {
    private Player playerP1;
    private Player playerAI;
    private Deck deck;
    private Board board;
    @Given("^\\[Goblin\\]Enemy with only (\\d+) card$")
    public void goblin_Enemy_with_only_card(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Write code here that turns the phrase above into concrete actions
        deck = new Deck(5);
        playerP1 = new Player();
        playerAI = new Player();

        playerP1.Draw(deck);
        playerP1.Draw(deck);
        playerP1.Draw(deck);
        playerP1.Draw(deck);
        playerP1.Draw(deck);

        for (int i = 0; i < arg1; i++) {
            playerAI.Draw(deck);
        }

        board = new Board();
    }
    @When("^I play a Goblin card$")
    public void i_play_a_Goblin_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        board.PlayCard(new Goblin(), deck, PlayerTurn.player1, playerP1, playerAI, null);
    }

    @Then("^I recieve a Hand with (\\d+) card$")
    public void i_recieve_a_Hand_with_card(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(arg1, playerP1.hand.getNmbrOfCards());
    }

}
