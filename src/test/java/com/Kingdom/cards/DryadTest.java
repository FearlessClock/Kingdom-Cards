package com.Kingdom.cards;

import com.Kingdom.cards.Model.Dryad;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DryadTest {
	@org.junit.Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void TexttoString() throws Exception{
		Dryad dryad = new Dryad();
		
		Assert.assertEquals(dryad.toString(), "You get a Dryad\nPower : Steal a card in front of your opponent and add it in front of you without activating its power");
	}
}
