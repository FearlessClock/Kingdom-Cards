package com.Kingdom.cards.Features;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class TrollStep {
    private Board b;
    private Deck d;

    private Player p1;
    private Player p2;

    @Given("^some cards$")
    public void some_cards() throws Throwable {
        b = new Board();
        d = new Deck(3);
        p1 = new Player();
        p2 = new Player();
        b.PlayCard(new Gnome(),d , FieldController.PlayerTurn.player1, p1, p2);
        b.PlayCard(new Elf(), d, FieldController.PlayerTurn.player2, p1, p2);
    }

    @When("^I play a card$")
    public void i_play_a_card() throws Throwable {
        b.PlayCard(new Troll(), d, FieldController.PlayerTurn.player1, p1, p2);
    }

    @Then("^the card goes away$")
    public void the_card_goes_away() throws Throwable {
        List<Card> cardsP1 = b.getPlayer1Cards();
        Assert.assertTrue(cardsP1.size() > 0);
        if(cardsP1.size()>0)
        {
            Assert.assertEquals(cardsP1.get(0), new Elf());
        }

        List<Card> cardsP2 = b.getPlayer2Cards();
        Assert.assertTrue(cardsP2.size() > 1);
        if(cardsP2.size()>1)
        {
            Assert.assertEquals(cardsP2.get(1), new Troll());
        }
    }
}
