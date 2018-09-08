package net.serenitybdd.samples.junit.steps;

import net.serenitybdd.samples.junit.model.FrequentFlyer;
import net.serenitybdd.samples.junit.model.Status;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

// tag::testcase[]
public class TravellerStatusSteps extends TravellerSteps {                  // <1>

    @Step                                                                   // <2>
    public void a_traveller_joins_the_frequent_flyer_program() {
        frequentFlyer = FrequentFlyer.withInitialBalanceOf(0);
    }

    @Step("The traveller should have {0} status")                           // <3>
    public void traveller_should_have_a_status_of(Status expectedStatus) {
        assertThat(frequentFlyer.getStatus()).isEqualTo(expectedStatus);
    }
}
// end::testcase[]