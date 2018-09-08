package net.serenitybdd.samples.junit.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@DefaultUrl("http://www.google.com")
public class GooglePage extends PageObject {

    @FindBy(name="q")
    WebElement search;

    public void searchFor(String keywords) {
        search.sendKeys(keywords, Keys.ENTER);
        waitFor(titleContains(keywords  + " - Google"));
    }
}
