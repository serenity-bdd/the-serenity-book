package flyer;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import flyer.steps.TravellerEarningStatusPoints;

import static flyer.Status.Bronze;
import static flyer.Status.Silver;

//tag::classbody[]
@RunWith(SerenityRunner.class)
public class WhenEarningFrequentFlyerStatus {

    @Steps
    TravellerEarningStatusPoints tracy;

    @Test
    public void membersShouldStartWithBronzeStatus() {
        // GIVEN
        tracy.joins_the_frequent_flyer_program();

        // THEN
        tracy.should_have_a_status_of(Bronze);
    }

    @Test
    public void earnSilverAfter10000Points() {
        // GIVEN
        tracy.joins_the_frequent_flyer_program();

        // WHEN
        tracy.flies(10000);

        // THEN
        tracy.should_have_a_status_of(Silver);
    }}
//end::classbody[]
