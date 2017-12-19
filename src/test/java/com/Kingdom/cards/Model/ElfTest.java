package com.Kingdom.cards.Model;

import com.Kingdom.cards.Controllers.FieldController;
import com.Kingdom.cards.PlayerTurn;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElfTest {
    FieldController fieldController;
    @Before
    public void setUp() throws Exception {
        fieldController = new FieldController(null, PlayerTurn.player1);
    }

    @Test
    public void power() throws Exception {
        Elf elf = new Elf();
        int boardSize = fieldController.getBoard().getPlayer1Cards().size();
        elf.power(fieldController.getBoard(), fieldController.getDeck(), fieldController.getPlayer1(), fieldController.getPlayerAI(), PlayerTurn.player1, null);
        Assert.assertEquals(boardSize, fieldController.getBoard().getPlayer1Cards().size());
    }

}