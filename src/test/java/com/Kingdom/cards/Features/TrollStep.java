package com.Kingdom.cards.Features;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.Board;
import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Player;
import com.Kingdom.cards.Model.Troll;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TrollStep {
    Player p1;
    Player AI;
    Deck d;
    Board b;

    List<Card> p1Cards;
    List<Card> AICards;

    @Given("^A board with (\\d+) cards$")
    public void a_board_with_cards(int arg1) throws Throwable {
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
    }

    @When("^I play a Troll card$")
    public void i_play_a_Troll_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        b.PlayCard(new Troll(), d, FieldController.PlayerTurn.player1, p1, AI);
    }

    @Then("^The boards are swapped$")
    public void the_boards_are_swapped() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Card> AISwappedCards = b.getPlayerAICards();
        List<Card> P1SwappedCards = b.getPlayer1Cards();
        for (int i = 0; i < p1Cards.size(); i++) {
            Assert.assertEquals(p1Cards.get(i).GetRace(), AISwappedCards.get(i).GetRace() );
        }
        for (int i = 0; i < AICards.size(); i++) {
            Assert.assertEquals(AICards.get(i).GetRace(), P1SwappedCards.get(i).GetRace() );
        }
    }
}
