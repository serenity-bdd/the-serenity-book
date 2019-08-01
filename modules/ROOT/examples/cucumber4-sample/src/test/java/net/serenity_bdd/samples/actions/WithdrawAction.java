package net.serenity_bdd.samples.actions;

import net.thucydides.core.annotations.Step;

public class WithdrawAction {
    int accountIdentifier;

    public WithdrawAction fromAccount(int accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
        return this;
    }

    @Step("Withdraw ${0} from account #accountIdentifier")
    public void theSumOf(int amount) {
        // Perform the appropriate web service call
    }
}
