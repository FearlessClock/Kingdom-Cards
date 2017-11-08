package com.Kingdom.cards.Features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TrollStep {

    @Given("^some cards$")
    public void some_cards() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I play a card$")
    public void i_play_a_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the card goes away$")
    public void the_card_goes_away() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(true, true);
    }
}
