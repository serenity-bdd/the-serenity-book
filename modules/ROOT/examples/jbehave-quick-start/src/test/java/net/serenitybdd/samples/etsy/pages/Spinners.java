package net.serenity_bdd.samples.etsy.pages;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static java.util.stream.Collectors.toList;

/**
 * Created by john on 19/12/14.
 */
public class Spinners {
    public static ExpectedCondition<Boolean> noSpinnerToBeVisible() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By.cssSelector(".spinner-small"))
                        .stream()
                        .filter(element -> isVisible(element))
                        .collect(toList())
                        .isEmpty();
            }

            private boolean isVisible(WebElement element) {
                try {
                    return !element.isDisplayed();
                } catch (StaleElementReferenceException e) {
                    // Returns true because stale element reference implies that element
                    // is npo longer visible.
                    return true;
                }
            }
        };
    }
}
