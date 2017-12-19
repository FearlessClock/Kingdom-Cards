package com.Kingdom.cards;

import com.Kingdom.cards.Model.Korrigan;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KorriganTest
{
    @org.junit.Before
    public void setUp() throws Exception
    {
    }

	@Test
	public void GetRace() throws Exception{
		Korrigan kor = new Korrigan();
		Assert.assertEquals("Korrigan", kor.GetRace());
	}
}
