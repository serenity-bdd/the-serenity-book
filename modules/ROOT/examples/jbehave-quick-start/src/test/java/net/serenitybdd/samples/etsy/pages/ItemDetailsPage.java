package net.serenitybdd.samples.etsy.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static net.serenity_bdd.samples.etsy.pages.Spinners.noSpinnerToBeVisible;

/**
 * Created by john on 18/11/14.
 */
public class ItemDetailsPage extends PageObject {

    @FindBys({@FindBy(id="listing-page-cart"), @FindBy(tagName = "h1")})
    WebElement itemName;

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return $("#description-text").getText();
    }

    public void selectSize() {
        List<WebElementFacade> allSizes = findAll(By.id("inventory-variation-select-0"));
        if (!allSizes.isEmpty()) {
            find(By.id("inventory-variation-select-0")).selectByIndex(allSizes.size());
        }
    }

    public void addToCart() {
        waitFor(".buy-button button");
        for(int i = 0 ; i < 3; i++) {
            try {
                $(".buy-button button").click();
                break;
            }
            catch (StaleElementReferenceException staleReferenceException) {}
        }
    }

    public List<String> getProductVariationIds() {
        return findAll(".variation")
                .stream()
                .map(elt -> elt.getAttribute("id"))
                .filter(id -> !id.isEmpty())
                .collect(toList());
    }

    public void selectVariation(String variationId, int optionIndex) {
        find(By.id(variationId)).selectByIndex(optionIndex);
        if (spinnerIsVisible()) {
            waitFor(noSpinnerToBeVisible());
        }
    }

    private boolean spinnerIsVisible() {
        return containsElements(".spinner-small");
    }

}
