package com.Kingdom.cards.Features;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Korrigan;
import com.Kingdom.cards.Model.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class KorriganStep {
    private Player playerP1;
    private Player playerAI;
    private Deck deck;
    private Board board;

    @Given("^Enemy with only (\\d+) card$")
    public void enemy_with_only_card(int arg1) throws Throwable {
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

    @When("^I play a Korrigan card$")
    public void i_play_a_Korrigan_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         board.PlayCard(new Korrigan(), deck, FieldController.PlayerTurn.player1, playerP1, playerAI);
    }

    @Then("^I recieve (\\d+) card$")
    public void i_recieve_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         Assert.assertEquals(5+arg1, playerP1.hand.getNmbrOfCards());
    }


}
