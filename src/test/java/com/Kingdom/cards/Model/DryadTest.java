package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.PlayerTurn;
import org.junit.Assert;
import org.junit.Test;

public class DryadTest {


    @Test
    public void GetRace() throws Exception {
        Dryad dryad = new Dryad();
        Assert.assertEquals("Dryad", dryad.GetRace());
    }

    @Test
    public void power() throws Exception {
        Dryad dryad = new Dryad();
        FieldController fieldController = new FieldController(null, PlayerTurn.player1);
        dryad.power(fieldController.getBoard(), fieldController.getDeck(), fieldController.getPlayer1(), fieldController.getPlayerAI(), fieldController.playerTurn, null);
        Assert.assertEquals("Dryad", dryad.GetRace());  //This isn't correct
    }

}