package flyer.steps;

import flyer.FrequentFlyer;
import flyer.Status;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

/// [classbody]
/// [preamble]
public class TravellerEarningStatusPoints { //<1>

    private String actor; // <2>

    private FrequentFlyer frequentFlyer;

    /// [preamble]
    /// [joins]
    @Step("#actor joins the frequent flyer program")  // <3> <4>
    public void joins_the_frequent_flyer_program() {
        frequentFlyer = FrequentFlyer.withInitialBalanceOf(0);
    }
    /// [joins]

    @Step("#actor flies {0} km") // <5>
    public void flies(int distance) {
        frequentFlyer.recordFlightDistanceInKilometers(distance);
    }

    @Step("#actor should have a status of {0}")
    public void should_have_a_status_of(Status expectedStatus) {
        assertThat(frequentFlyer.getStatus()).isEqualTo(expectedStatus);
    }

    @Step("#actor transfers {0} points to {1}")
    public void transfers_points(int points, TravellerEarningStatusPoints otherFrequentFlier) {
        // Left as an exercise
    }

    @Override
    public String toString() {
        return actor;
    }

    @Step("#actor should have {0} points")
    public void should_have_points(int expectedPoints) {
        // Left as an exercise
    }
}
/// [classbody]
