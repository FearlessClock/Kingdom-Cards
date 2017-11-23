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
    Player playerP1;
    Player playerAI;
    Deck deck;
    Board board;

    List<Card> p1Cards;
    List<Card> AICards;

    @Given("^A board with (\\deck+) cards$")
    public void a_board_with_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        deck = new Deck(5);
        playerP1 = new Player();
        playerAI = new Player();

        board = new Board();
        p1Cards = new ArrayList<Card>();
        AICards = new ArrayList<Card>();
        for (int i = 0; i < arg1; i++) {
            p1Cards.add(deck.GetFirstCard());
            AICards.add(deck.GetFirstCard());
        }
        board.setPlayer1Cards(p1Cards);
        board.setPlayerAICards(AICards);
    }

    @When("^I play a Troll card$")
    public void i_play_a_Troll_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        board.PlayCard(new Troll(), deck, FieldController.PlayerTurn.player1, playerP1, playerAI);
    }

    @When("^playerAI plays a Troll card$")
    public void ai_plays_a_Troll_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        board.PlayCard(new Troll(), deck, FieldController.PlayerTurn.playerAI, playerP1, playerAI);
    }


    @Then("^The boards are swapped$")
    public void the_boards_are_swapped() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Card> AISwappedCards = board.getPlayerAICards();
        List<Card> P1SwappedCards = board.getPlayer1Cards();
        for (int i = 0; i < p1Cards.size(); i++) {
            Assert.assertEquals(p1Cards.get(i).GetRace(), AISwappedCards.get(i).GetRace() );
        }
        for (int i = 0; i < AICards.size(); i++) {
            Assert.assertEquals(AICards.get(i).GetRace(), P1SwappedCards.get(i).GetRace() );
        }
    }
}
