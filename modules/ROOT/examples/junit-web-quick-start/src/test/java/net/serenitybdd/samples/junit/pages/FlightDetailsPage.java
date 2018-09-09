package net.serenitybdd.samples.junit.pages;

import net.thucydides.core.pages.PageObject;

/**
 * Created by john on 6/12/14.
 */
public class FlightDetailsPage extends PageObject {
    public String getDepartureCity() {
        return "Sydney";
    }

    public String getDestinationCity() {
        return "London";
    }
}
