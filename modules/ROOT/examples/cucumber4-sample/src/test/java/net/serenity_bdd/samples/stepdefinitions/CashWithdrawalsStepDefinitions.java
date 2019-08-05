package net.serenity_bdd.samples.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenity_bdd.samples.actions.AccountBalanceAction;
import net.serenity_bdd.samples.actions.CreateAccountAction;
import net.serenity_bdd.samples.actions.WithdrawAction;
import net.serenity_bdd.samples.domain.AccountType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class CashWithdrawalsStepDefinitions {

    @Shared
    CreateAccountAction createAnAccount;

    @Steps
    WithdrawAction withdraw;

    @Steps
    AccountBalanceAction accountBalance;

    int accountIdentifier;

    @Given("{word} has ${int} in his {AccountType} account")
    public void in_his_current_account(String customer, int balance, AccountType accountType) {
       accountIdentifier = createAnAccount.forCustomer(customer).ofType(accountType).withABalanceOf(balance);
    }

    @When("he withdraws ${int} in cash")
    public void he_withdraws_in_cash(int withdrawal) {
        withdraw.fromAccount(accountIdentifier).theSumOf(withdrawal);
    }

    @Then("his remaining balance should be ${int}")
    public void his_remaining_balance_should_be(int expectedBalance) {
        assertThat(accountBalance.forAccount(accountIdentifier)).isEqualTo(expectedBalance);
    }
}
