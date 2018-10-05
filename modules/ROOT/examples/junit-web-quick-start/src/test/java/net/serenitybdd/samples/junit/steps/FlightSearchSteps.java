package net.serenitybdd.samples.junit.steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.samples.junit.pages.FlightDetailsPage;
import net.serenitybdd.samples.junit.pages.FlightSearchPage;
import net.serenitybdd.samples.junit.pages.FlightSearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

// tag::classbody[]
public class FlightSearchSteps extends ScenarioSteps {

    FlightSearchPage flightSearchPage;
    FlightSearchResultsPage flightSearchResultsPage;
    FlightDetailsPage flightDetailsPage;

    @Step("A customer searchers for flights between {0} and {1}")
    public void searches_for_flights_between(String departure, String destination) {
        Serenity.setSessionVariable("destinationCity").to(destination); //<1>

        flightSearchPage.searchForFlightsFrom(departure).to(destination);
    }

    @Step
    public void view_flight_details_for_flight(int flightNumber) {
        flightSearchResultsPage.selectFlightNumber(flightNumber);
    }

    @Step
    public void should_see_the_destination_city_in_the_summary() {
        String expectedDestinationCity
                = Serenity.sessionVariableCalled("destinationCity").toString(); //<2>

        assertThat(flightDetailsPage.getDestinationCity()).isEqualTo(expectedDestinationCity);
    }
}
// end::classbody[]