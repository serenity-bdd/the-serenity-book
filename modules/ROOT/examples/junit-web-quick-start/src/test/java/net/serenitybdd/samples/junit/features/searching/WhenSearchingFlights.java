package net.serenitybdd.samples.junit.features.searching;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.samples.junit.steps.FlightSearchSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

// tag::narrative[]
@Narrative(text={"In order to choose the best flight for my travels",                      //<1>
                 "As a traveller",
                 "I want to be able to search for flights between specific destinations"})
// end::narrative[]
// tag::testcase[]
@RunWith(SerenityRunner.class)
public class WhenSearchingFlights {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    FlightSearchSteps theCustomer;

    @Test
    public void should_display_selected_flight_details() {
        // GIVEN
        theCustomer.searches_for_flights_between("Sydney", "London");
        // WHEN
        theCustomer.view_flight_details_for_flight(1);
        // THEN
        theCustomer.should_see_the_destination_city_in_the_summary();
    }
}
// end::testcase[]