package net.serenitybdd.example;

import net.serenitybdd.example.pages.Home;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SerenityRunner.class)
public class EnvironmentTest {

    @Managed
    private
    WebDriver aBrowser;

    private Actor james = Actor.named("James");

    @Before
    public void jamesCanBrowseTheWeb() {
        james.can(BrowseTheWeb.with(aBrowser));
    }

    @Test
    public void defaultTest() {
        Assume.assumeThat(System.getProperty("environment"), is(nullValue()));
        james.attemptsTo(Open.browserOn().the(new Home()));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("default"));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("home"));
    }

    @Test
    public void defaultNamedPageTest() {
        Assume.assumeThat(System.getProperty("environment"), is(nullValue()));
        james.attemptsTo(Open.browserOn().thePageNamed("named.page"));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("default"));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("named"));
    }

    @Test
    public void prodTest() {
        Assume.assumeThat(System.getProperty("environment"), is("prod"));
        james.attemptsTo(Open.browserOn().the(new Home()));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("prod"));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("home"));
    }

    @Test
    public void prodNamedPageTest() {
        Assume.assumeThat(System.getProperty("environment"), is("prod"));
        james.attemptsTo(Open.browserOn().thePageNamed("named.page"));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("prod"));
        assertThat(BrowseTheWeb.as(james).getDriver().getCurrentUrl(), containsString("named"));
    }
}
