package net.serenitybdd.samples.junit.features.searching;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.samples.junit.pages.GooglePage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

// tag::testcase[]
@RunWith(SerenityParameterizedRunner.class)
@Concurrent                                                 //<1>
public class WhenSearchingForDifferentTermsOnGoogle {

    @Managed(driver = "chrome")
    WebDriver driver;

    GooglePage googlePage;

    @TestData                                               //<2>
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"cats"},
                {"dogs"},
                {"ferrets"},
                {"rabbits"},
                {"canaries"}
        });
    }

    private final String searchTerm;                        //<3>

    public WhenSearchingForDifferentTermsOnGoogle(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Test
    public void shouldInstantiatedPageObjectsForADataDrivenWebTest() {

        googlePage.open();

        googlePage.searchFor(searchTerm);

        assertThat(googlePage.getTitle()).startsWith(searchTerm + " - Google");
    }
}
// end::testcase[]

