package flyer;

import flyer.steps.TravellerEarningStatusPoints;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static flyer.Status.Bronze;
import static flyer.Status.Silver;

//tag::classbody[]
@RunWith(SerenityRunner.class)
public class WhenTransferringFrequentFlyerPoints {

    @Steps
    TravellerEarningStatusPoints tracy;

    @Steps
    TravellerEarningStatusPoints troy;

    @Test
    public void memberCanTransferPointsToAnotherMemberWithoutLosingStatus() {
        // GIVEN
        tracy.joins_the_frequent_flyer_program();
        troy.joins_the_frequent_flyer_program();

        // AND
        tracy.flies(20000);

        // WHEN
        tracy.transfers_points(15000, troy);

        // THEN
        tracy.should_have_a_status_of(Silver);
    }
}
//end::classbody[]
