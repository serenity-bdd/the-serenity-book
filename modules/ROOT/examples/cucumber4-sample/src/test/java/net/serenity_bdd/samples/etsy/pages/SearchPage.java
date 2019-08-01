package net.serenity_bdd.samples.etsy.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl("https://duckduckgo.com")
public class SearchPage extends PageObject {

    public void searchBy(String keyword) {
        $("#search_form_input_homepage").sendKeys(keyword, Keys.ENTER);
    }
}
