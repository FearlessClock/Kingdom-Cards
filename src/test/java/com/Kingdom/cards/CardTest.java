package com.Kingdom.cards;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void GetCardRace() throws Exception {
        Card card = new Card();

        Assert.assertEquals(card.GetRace(), "Human");
    }
}