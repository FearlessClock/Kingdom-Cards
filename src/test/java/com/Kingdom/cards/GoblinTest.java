package com.Kingdom.cards;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoblinTest {
	@org.junit.Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void TexttoString() throws Exception{
		Goblin goblin = new Goblin();
		
		Assert.assertEquals(goblin.toString(), "You get a Goblin\nPower : Switch your hand with you opponent");
	}
}
