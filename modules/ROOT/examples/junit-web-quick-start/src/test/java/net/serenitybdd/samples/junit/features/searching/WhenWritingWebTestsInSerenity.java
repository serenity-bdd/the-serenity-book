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

// tag::webtest[]
@RunWith(SerenityRunner.class)                                              //<1>
public class WhenWritingWebTestsInSerenity {

    @Managed                                                            //<2>
    WebDriver driver;

    @Test
    public void shouldInstantiateAWebDriverInstanceForAWebTest() {
        driver.get("http://www.google.com");                                //<3>

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        new WebDriverWait(driver,5).until(titleContains("firefly - Google"));

        assertThat(driver.getTitle()).contains("firefly - Google");
    }                                                                      //<4>
}
// end::webtest[]

