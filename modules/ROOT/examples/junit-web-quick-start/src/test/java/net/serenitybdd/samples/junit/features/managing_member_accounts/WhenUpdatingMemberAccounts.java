package net.serenitybdd.samples.junit.features.managing_member_accounts;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.samples.junit.steps.TravellerHistorySteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.samples.junit.model.Status.*;

// tag::testcase[]
@RunWith(SerenityRunner.class)
public class WhenUpdatingMemberAccounts {

    @Steps
    TravellerHistorySteps travellerSteps;

    @Test
    public void shouldFetchFlightHistoryFromMainframe() {
        // ASSUMPTION
        travellerSteps.assuming_the_mainframe_is_available();

        // WHEN
        travellerSteps.we_fetch_the_latest_flight_history_for_a_traveller();

        // THEN
        travellerSteps.traveller_should_see_the_latest_flights();
    }
}
// end::testcase[]

