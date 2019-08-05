package net.serenity_bdd.samples.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenity_bdd.samples.domain.AccountDetails;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class InternalTransferStepDefinitions {
    @Given("Clive has the following accounts:")
    public void cliveHasTheFollowingAccounts(List<AccountDetails> accounts) {
    }

    @Then("^his new account balances should be:$")
    public void hisNewAccountBalancesShouldBe(DataTable expectedAccountBalances) {
    }

    @When("^he transfers \\$(\\d+) from his Current account to his Savings account$")
    public void heTransfers$FromHisCurrentAccountToHisSavingsAccount(int arg0) {
    }
}
