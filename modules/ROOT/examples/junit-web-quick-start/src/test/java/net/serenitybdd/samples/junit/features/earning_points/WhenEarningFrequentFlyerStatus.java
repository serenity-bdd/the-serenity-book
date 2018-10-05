package net.serenitybdd.samples.junit.features.earning_points;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.samples.junit.steps.TravellerStatusSteps;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.samples.junit.model.Status.*;

// tag::header[]
@RunWith(SerenityRunner.class)
public class WhenEarningFrequentFlyerStatus {

    @Steps
    TravellerStatusSteps travellerSteps;
    // end::header[]
    // tag::membersShouldStartWithBronzeStatus[]

    @Test
    public void membersShouldStartWithBronzeStatus() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // THEN
        travellerSteps.traveller_should_have_a_status_of(Bronze);
    }
    // end::membersShouldStartWithBronzeStatus[]
    // tag::earnSilverAfter1000Points[]

    @Test
    public void earnSilverAfter1000Points() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(10000);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(Silver);
    }
    //end::earnSilverAfter1000Points[]
    // tag::earnGoldAfter5000Points[]

    @Test
    @Title("Members earn Gold status after 5000 points (50000 km)")         //<1>
    public void earnGoldAfter5000Points() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(50000);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(Gold);
    }
    //end::earnGoldAfter5000Points[]
    // tag::pendingTest[]

    @Test
    @Pending
    public void dropsBackToSilverIfLessThan8000PointsEarnedInAYear() {
    }
    //end::pendingTest[]
    //tag::ignoredTest[]

    @Test
    @Ignore
    public void earnPlatinumAfter10000Points() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(500000);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(Platinum);
    }
    //end::ignoredTest[]

// tag::endTest[]
}
// end::endTest[]

