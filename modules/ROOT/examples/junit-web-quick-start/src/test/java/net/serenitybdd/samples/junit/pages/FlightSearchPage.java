package net.serenitybdd.samples.junit.pages;

import net.thucydides.core.pages.PageObject;

/**
 * Created by john on 6/12/14.
 */
public class FlightSearchPage extends PageObject {
    public FlightSearchBuilder searchForFlightsFrom(String departure) {
        return new FlightSearchBuilder();
    }

    public class FlightSearchBuilder {
        public void to(String destination) {

        }
    }
}
