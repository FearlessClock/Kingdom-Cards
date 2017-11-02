package com.Kingdom.cards;

import com.Kingdom.cards.Model.Gnome;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GnomeTest {
	@org.junit.Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void TexttoString() throws Exception{
		Gnome gnome = new Gnome();
		
		Assert.assertEquals(gnome.toString(), "You get a Gnome\nPower : Draw 2 cards");
	}
}
