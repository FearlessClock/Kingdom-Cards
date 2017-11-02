package com.Kingdom.cards;

import com.Kingdom.cards.Model.Troll;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrollTest {
	@org.junit.Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void TexttoString() throws Exception{
		Troll troll = new Troll();
		
		Assert.assertEquals(troll.toString(), "You get a Troll\nPower : Swap the cards in front of you with the cards in front of your opponent");
	}
	
	
	
}
