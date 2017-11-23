package com.Kingdom.cards.Features;
import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DryadStep {
    Player p1;
    Player AI;
    Deck d;
    Board b;
    List<Card> p1Cards;
    List<Card> AICards;

    int boardSize = 0;

    @Given("^\\[Dryad\\]A board with (\\d+) cards$")
    public void dryad_A_board_with_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        d = new Deck(5);
        p1 = new Player();
        AI = new Player();

        b = new Board();

        p1Cards = new ArrayList<Card>();
        AICards = new ArrayList<Card>();
        for (int i = 0; i < arg1; i++) {
            p1Cards.add(d.GetFirstCard());
            AICards.add(d.GetFirstCard());
        }
        b.setPlayer1Cards(p1Cards);
        b.setPlayerAICards(AICards);
        boardSize = arg1;
    }

    @When("^I play a Dryad card$")
    public void i_play_a_Dryad_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        b.PlayCard(new Dryad(), d, FieldController.PlayerTurn.player1, p1, AI, false);
    }

    @Then("^My board grew by (\\d+) and enemy srunk by (\\d+)$")
    public void my_board_grew_by_and_enemy_srunk_by(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(boardSize+arg1, b.getPlayer1Cards().size());
        Assert.assertEquals(boardSize-arg2, b.getPlayerAICards().size());
    }


}
