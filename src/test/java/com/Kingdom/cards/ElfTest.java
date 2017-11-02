package com.Kingdom.cards;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElfTest {
	@org.junit.Before
    public void setUp() throws Exception {
    }
	
	@Test
	public void TexttoString() throws Exception{
		Elf elf = new Elf();
		
		Assert.assertEquals(elf.toString(), "You get a Elf\nPower : Copy and use the power of one of the card in front of you");
	}
}
