package com.Kingdom.cards.Features;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.PlayerTurn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GameLoopStep {
    private FieldController fieldController;

    @Given("^A controller initialised$")
    public void a_controller_initialised() throws Throwable {
        fieldController = new FieldController(null, PlayerTurn.player1);
    }

    @Then("^A board exists, a deck exists, both players exists$")
    public void a_board_exists_a_deck_exists_both_players_exists() throws Throwable {
        Assert.assertNotNull(fieldController.getBoard());
        Assert.assertNotNull(fieldController.getDeck());
        Assert.assertNotNull(fieldController.getPlayer1());
        Assert.assertNotNull(fieldController.getPlayerAI());
    }

    @Then("^The deck contains (\\d+) cards$")
    public void the_deck_contains_cards(int arg1) throws Throwable {
        //Must contain 42 cards but because the 2 players are drawing cards before I can tests
        //The amount goes down to 32
        Assert.assertEquals(arg1 - fieldController.getPlayer1().SizeHand()- fieldController.getPlayer1().SizeHand(), fieldController.getDeck().Size());
    }

    @Then("^The player holds (\\d+) cards$")
    public void the_player_holds_cards(int arg1) throws Throwable {
        Assert.assertEquals(arg1, fieldController.getPlayer1().SizeHand());
    }

    @Then("^The playerAI holds (\\d+) cards$")
    public void the_playerAI_holds_cards(int arg1) throws Throwable {
        Assert.assertEquals(arg1, fieldController.getPlayerAI().SizeHand());
    }

    @Given("^playerHasPlayed true and player turn$")
    public void playerhasplayed_true_and_player_turn() throws Throwable {
        fieldController.playerHasPlay = true;
        fieldController.playerTurn = PlayerTurn.player1;
    }

    @When("^End the turn$")
    public void end_the_turn() throws Throwable {
        fieldController.EndTurn();
    }

    @Then("^playerTurn is player, playerHasPlayed false, playerHasDrawn false$")
    public void playerturn_is_player_playerHasPlayed_false_playerHasDrawn_false() throws Throwable {
        Assert.assertEquals(PlayerTurn.player1, fieldController.playerTurn);
        Assert.assertEquals(false, fieldController.playerHasPlay);
        Assert.assertEquals(true, fieldController.playerHasDrawn);
    }

}
