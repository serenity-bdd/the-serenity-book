package net.serenitybdd.samples.junit.steps;

import net.serenitybdd.samples.junit.model.FrequentFlyer;
import net.serenitybdd.samples.junit.model.Status;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

// tag::classbody[]
public class TravellerSteps {

    FrequentFlyer frequentFlyer;                                                        // <1>

    @Step("Given a traveller has a frequent flyer account with {0} points")             // <2>
    public void a_traveller_has_a_frequent_flyer_account_with_balance(int initialBalance) {
        frequentFlyer = FrequentFlyer.withInitialBalanceOf(initialBalance);             // <3>
    }

    @Step("When the traveller flies {0} km")
    public void the_traveller_flies(int distance) {
        frequentFlyer.flies(distance).kilometers();                                     // <4>

    }

    @Step("Then the traveller should have a balance of {0} points")
    public void traveller_should_have_a_balance_of(int expectedBalance ) {
        assertThat(frequentFlyer.getBalance()).isEqualTo(expectedBalance);              // <5>
    }

    @Step
    public void a_traveller_joins_the_frequent_flyer_program() {
        frequentFlyer = FrequentFlyer.withInitialBalanceOf(0);
    }

    @Step
    public void traveller_should_have_a_status_of(Status expectedStatus) {
        assertThat(frequentFlyer.getStatus()).isEqualTo(expectedStatus);
    }
}
// end::classbody[]
