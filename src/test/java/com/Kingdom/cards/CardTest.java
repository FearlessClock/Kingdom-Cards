package com.Kingdom.cards;

import com.Kingdom.cards.Model.Card;
import com.Kingdom.cards.Model.Elf;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void GetCardRace() throws Exception {
        Elf card = new Elf();

        Assert.assertEquals(card.GetRace(), "Elf");
    }


}