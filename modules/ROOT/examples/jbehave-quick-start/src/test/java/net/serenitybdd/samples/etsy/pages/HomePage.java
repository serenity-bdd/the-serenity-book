package net.serenitybdd.samples.etsy.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// tag::header[]
@DefaultUrl("http://www.etsy.com")                      // <1>
public class HomePage extends PageObject {              // <2>
// end::header[]
// tag::searchByKeyword[]

    @FindBy(css = "button[value='Search']")
    WebElement searchButton;

    public void searchFor(String keywords) {
        $("#search-query").sendKeys(keywords);          // <3>
        searchButton.click();                           // <4>
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
        waitForAbsenceOf("Your preferences have been saved");
    }

    public void dismissPrivacyMessage() {
        if (!findAll(By.xpath("//button[text()='Accept']")).isEmpty()) {
            find(By.xpath("//button[text()='Accept']")).click();
        }
        waitForAbsenceOf("Update settings");
        if (!findAll(By.xpath("//button[text()='I understand']")).isEmpty()) {
            find(By.xpath("//button[text()='I understand']")).click();
        }
    }

// end::sear chByKeyword[]
// tag::tail[]
}
// end::tail[]