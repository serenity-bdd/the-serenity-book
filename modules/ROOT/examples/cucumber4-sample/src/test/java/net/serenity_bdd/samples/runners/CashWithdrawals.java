package net.serenity_bdd.samples.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)                    // <1>
@CucumberOptions(
        features="src/test/resources/features/banking_app/deposits_and_withdrawals/inter_bank_transfers.feature",    // <2>
        glue = "net.serenity_bdd.samples")              // <3>
public class CashWithdrawals {
}
