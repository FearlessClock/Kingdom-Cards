package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.PlayerTurn;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GnomeTest {
    FieldController fieldController;
    @Before
    public void setUp() throws Exception {
        fieldController = new FieldController(null, PlayerTurn.player1);
    }

    @Test
    public void power() throws Exception {
        Gnome gnome = new Gnome();
        int playerHandSize = fieldController.getPlayer1().hand.getHand().size();
        gnome.power(fieldController.getBoard(), fieldController.getDeck(), fieldController.getPlayer1(), fieldController.getPlayerAI(), fieldController.playerTurn, null);
        Assert.assertEquals(playerHandSize+2, fieldController.getPlayer1().hand.getHand().size());
    }

}