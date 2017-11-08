package com.Kingdom.cards.Features;
import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GnomeStep {

    Player p1;
    Player AI;
    Deck d;
    Board b;


    @Given("^A deck with (\\d+) cards$")
    public void a_deck_with_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        d = new Deck(1);    //Gives me a deck of 6 cards
        p1 = new Player();
        AI = new Player();
        for (int i = 0; i < 6 - arg1; i++) {    //Make my deck have arg1 amount of cards
            AI.Draw(d);
        }

        b = new Board();
    }

    @When("^I play a Gnome card$")
    public void i_play_a_Gnome_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        b.PlayCard(new Gnome(), d, FieldController.PlayerTurn.player1, p1, AI);
    }

    @Then("^My hand has (\\d+) more cards$")
    public void my_hand_has_more_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertEquals(arg1, p1.hand.getNmbrOfCards());
    }


}
