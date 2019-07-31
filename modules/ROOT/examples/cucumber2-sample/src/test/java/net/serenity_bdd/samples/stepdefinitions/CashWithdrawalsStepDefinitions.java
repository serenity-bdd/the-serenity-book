package net.serenity_bdd.samples.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CashWithdrawalsStepDefinitions {

    @Given("^(.*) has \\$(\\d+) in his (.*) account$")
    public void in_his_current_account(String customer, int balance, String accountType) {
    }

    @When("^he withdraws \\$(\\d+) in cash$")
    public void he_withdraws_$_in_cash(int withdrawal) {
    }

    @Then("^his remaining balance should be \\$(\\d+)$")
    public void his_remaining_balance_should_be(int expectedBalance) {
    }


    @Given("^Clive has an (.*) account with a balance of (\\d+)$")
    public void clive_has_an_Savings_account_with_a_balance_of(String accountType, int balance) {
    }

    @When("^the monthly fees are calculated$")
    public void theMonthlyFeesAreCalculated() {

    }

    @Then("^a \"(.*)\" monthly fee of (.*) should be deducted$")
    public void aMonthlyFeeMonthlyFeeOfSampleFeeShouldBeDeducted(String feeType, String feeAmount) {

    }
}
