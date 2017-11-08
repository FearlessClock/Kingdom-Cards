package com.Kingdom.cards.Features;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Goblin;
import com.Kingdom.cards.Model.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GoblinStep {
    Player p1;
    Player AI;
    Deck d;
    Board b;
    @Given("^\\[Goblin\\]Enemy with only (\\d+) card$")
    public void goblin_Enemy_with_only_card(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Write code here that turns the phrase above into concrete actions
        d = new Deck(5);
        p1 = new Player();
        AI = new Player();

        p1.Draw(d);
        p1.Draw(d);
        p1.Draw(d);
        p1.Draw(d);
        p1.Draw(d);

        for (int i = 0; i < arg1; i++) {
            AI.Draw(d);
        }

        b = new Board();
    }
    @When("^I play a Goblin card$")
    public void i_play_a_Goblin_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        b.PlayCard(new Goblin(), d, FieldController.PlayerTurn.player1, p1, AI);
    }

    @Then("^I recieve a Hand with (\\d+) card$")
    public void i_recieve_a_Hand_with_card(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(arg1, p1.hand.getNmbrOfCards());
    }

}
