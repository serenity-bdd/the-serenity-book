package net.serenitybdd.samples.junit.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static net.serenitybdd.samples.junit.steps.MainframeStatus.OFFLINE;
import static net.serenitybdd.samples.junit.steps.MainframeStatus.ONLINE;
// tag::header[]
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeThat;

public class TravellerHistorySteps extends ScenarioSteps {
    // end::header[]

    //tag::assumptionSteps[]
    @Step
    public void assuming_the_mainframe_is_available() {
        assumeThat(mainframe(), is(ONLINE));                        // <1>
    }

    private MainframeStatus mainframe() {
        return OFFLINE;                                             // <2>
    }
    //end::assumptionSteps[]

    @Step
    public void we_fetch_the_latest_flight_history_for_a_traveller() {
        // Interact with the mainframe
    }

    @Step
    public void traveller_should_see_the_latest_flights() {
        // Check the latest accounts
    }
}
