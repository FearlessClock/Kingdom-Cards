package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.PlayerTurn;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoblinTest {
    FieldController fieldController;
    @Before
    public void setUp() throws Exception {
        fieldController = new FieldController(null, PlayerTurn.player1);
    }

    @Test
    public void power() throws Exception {
        Goblin goblin = new Goblin();
        fieldController.getPlayer1().hand.getHand().remove(0);
        int player1HandSize = fieldController.getPlayer1().SizeHand();
        int playerAIHandSize = fieldController.getPlayerAI().SizeHand();
        goblin.power(fieldController.getBoard(), fieldController.getDeck(), fieldController.getPlayer1(), fieldController.getPlayerAI(), fieldController.playerTurn, null);
        Assert.assertEquals(player1HandSize-1, fieldController.getPlayerAI().SizeHand());
        Assert.assertEquals(playerAIHandSize, fieldController.getPlayer1().SizeHand());
    }

}