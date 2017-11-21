package com.Kingdom.cards.Features;

import com.Kingdom.cards.Controllers.FieldController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GameSetupStep {
    FieldController fieldController;
    @Given("^A new field controller$")
    public void a_new_field_controller() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fieldController = new FieldController();
    }

    @When("^The game is setup$")
    public void the_game_is_setup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fieldController.initialize();
    }

    @Then("^I have a deck wih (\\d+) cards, two players with (\\d+) cards each and (\\d+) empty fields$")
    public void i_have_a_deck_wih_cards_players_with_cards_each_and_empty_fields(int arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        Assert.assertEquals(fieldController.GetDeck().Size(), arg1);
//        Assert.assertEquals(fieldController.getPlayer1().hand.getNmbrOfCards(), arg2);
//        Assert.assertEquals(fieldController.getPlayerAI().hand.getNmbrOfCards(), arg2);
//        Assert.assertEquals(fieldController.getBoard().getPlayer1Cards(), arg3);
//        Assert.assertEquals(fieldController.getBoard().getPlayerAICards(), arg3);
    }
}
