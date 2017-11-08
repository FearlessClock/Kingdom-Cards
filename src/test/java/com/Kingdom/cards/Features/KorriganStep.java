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
    Player p1;
    Player AI;
    Deck d;
    Board b;

    @Given("^Enemy with only (\\d+) card$")
    public void enemy_with_only_card(int arg1) throws Throwable {
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

    @When("^I play a Korrigan card$")
    public void i_play_a_Korrigan_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         b.PlayCard(new Korrigan(), d, FieldController.PlayerTurn.player1, p1, AI);
    }

    @Then("^I recieve (\\d+) card$")
    public void i_recieve_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         Assert.assertEquals(p1.hand.getNmbrOfCards(), 5+arg1);
    }


}
