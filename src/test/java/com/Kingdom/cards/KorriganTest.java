package com.Kingdom.cards;

import com.Kingdom.cards.Model.Korrigan;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KorriganTest {
	@org.junit.Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void TexttoString() throws Exception{
		Korrigan korrigan = new Korrigan();
		
		Assert.assertEquals(korrigan.toString(), "You get a Korrigan\nPower : Draw 2 random cards within your opponent hand");
	}
}
