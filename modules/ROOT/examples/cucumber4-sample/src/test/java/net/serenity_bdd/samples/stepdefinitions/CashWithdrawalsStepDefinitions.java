package net.serenity_bdd.samples.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CashWithdrawalsStepDefinitions {

    @Given("{word} has ${int} in his {word} account")
    public void in_his_current_account(String customer, int balance, String accountType) {
    }

    @When("he withdraws ${int} in cash")
    public void he_withdraws_in_cash(int withdrawal) {
    }

    @Then("his remaining balance should be ${int}")
    public void his_remaining_balance_should_be(int expectedBalance) {
    }
}
