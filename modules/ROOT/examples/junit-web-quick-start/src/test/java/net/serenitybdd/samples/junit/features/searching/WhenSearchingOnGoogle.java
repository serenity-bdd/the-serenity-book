package net.serenitybdd.samples.junit.features.searching;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.samples.junit.pages.GooglePage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.findby.By;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

// tag::header[]
@RunWith(SerenityRunner.class)
public class WhenSearchingOnGoogle {

    @Managed                                                                //<1>
    WebDriver driver;
// end::header[]
// tag::pageObjects[]

    GooglePage googlePage;                                                  //<1>
// end::pageObjects[]
// tag::simpletest[]

    @Test
    public void shouldInstantiateAWebDriverInstanceForAWebTest() {
        driver.get("http://www.google.com");                                //<2>

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        new WebDriverWait(driver,5).until(titleContains("firefly - Google"));

        assertThat(driver.getTitle()).contains("firefly - Google");
    }
// end::simpletest[]
// tag::pageObjectTest[]

    @Test
    public void shouldInstantiatedPageObjectsForAWebTest() {

        googlePage.open();                                                  //<2>

        googlePage.searchFor("firefly");

        assertThat(googlePage.getTitle()).contains("firefly - Google");
    }
// end::pageObjectTest[]
// tag::endTest[]
}
// end::endTest[]

