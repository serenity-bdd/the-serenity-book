package net.serenitybdd.samples.junit.features.earning_points;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.samples.junit.model.Status;
import net.serenitybdd.samples.junit.steps.TravellerStatusSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


// tag::testcase[]
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="testdata/status-levels.csv")                //<1>
public class WhenEarningFrequentFlyerStatusUpgradesUsingCSV {

    private int kilometersTravelled;
    private Status expectedStatus;

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    public void setExpectedStatus(String expectedStatus) {
        this.expectedStatus = Status.valueOf(expectedStatus);
    }

    @Qualifier
    public String qualifier() {
        return kilometersTravelled + "=>" + expectedStatus;
    }
    @Steps
    TravellerStatusSteps travellerSteps;

    @Test
    public void reallyhouldEarnNextStatusWithEnoughPoints() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(kilometersTravelled);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(expectedStatus);
    }
}
// end::testcase[]

