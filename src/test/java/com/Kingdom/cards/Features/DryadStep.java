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
    Player player1;
    Player playerAI;
    Deck deck;
    Board board;
    List<Card> p1Cards;
    List<Card> AICards;

    int boardSize = 0;

    @Given("^\\[Dryad\\]A board with (\\deck+) cards$")
    public void dryad_A_board_with_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        deck = new Deck(5);
        player1 = new Player();
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
        boardSize = arg1;
    }

    @When("^I play a Dryad card$")
    public void i_play_a_Dryad_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        board.PlayCard(new Dryad(), deck, FieldController.PlayerTurn.player1, player1, playerAI);
    }

    @Then("^My board grew by (\\deck+) and enemy srunk by (\\deck+)$")
    public void my_board_grew_by_and_enemy_srunk_by(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(boardSize+arg1, board.getPlayer1Cards().size());
        Assert.assertEquals(boardSize-arg2, board.getPlayerAICards().size());
    }


}
