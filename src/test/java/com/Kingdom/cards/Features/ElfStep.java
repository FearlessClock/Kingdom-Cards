package com.Kingdom.cards.Features;

import com.Kingdom.cards.Deck;
import com.Kingdom.cards.Model.*;
import com.Kingdom.cards.PlayerTurn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class ElfStep {
    private Player player1;
    private Player playerAI;
    private Deck deck;
    private Board board;
    private List<Card> p1Cards;
    private List<Card> AICards;

    private int boardSize = 0;
    @Given("^\\[Elf\\]A board with (\\d+) cards$")
    public void elf_A_board_with_cards(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
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

    @When("^I play a Elf card$")
    public void i_play_a_Elf_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        board.PlayCard(new Elf(), deck, PlayerTurn.player1, player1, playerAI, null);
    }


}
