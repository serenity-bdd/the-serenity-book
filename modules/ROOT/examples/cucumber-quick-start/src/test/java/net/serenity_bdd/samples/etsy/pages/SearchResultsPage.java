package net.serenity_bdd.samples.etsy.pages;

import com.google.common.base.Optional;
import net.serenity_bdd.samples.etsy.features.model.ListingItem;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// tag::header[]
public class SearchResultsPage extends PageObject {
// end::header[]
// tag::searchByKeyword[]

    //@FindBy(css=".v2-listing-card")
    //List<WebElement> listingCards;

    public List<String> getResultTitles() {
        List<WebElementFacade> listingCards = findAll(".listing-link");
        return listingCards.stream()
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList());
    }
// end::searchByKeyword[]
    public ListingItem selectItem(int itemNumber) {
        List<WebElementFacade> listingCards = findAll(".n-listing-card__price");
        ListingItem selectedItem = convertToListingItem(listingCards.get(itemNumber - 1));
        listingCards.get(itemNumber - 1).findElement(By.tagName("a")).click();
        return selectedItem;
    }

    private ListingItem convertToListingItem(WebElement itemElement) {
        NumberFormat format = NumberFormat.getInstance();
        String price = itemElement.findElement(By.className("currency-value")).getText();

        try {
            return new ListingItem(itemElement.findElement(By.className("title")).getText(),
                                                           format.parse(price).doubleValue());
        } catch (ParseException e) {
            throw new AssertionError("Failed to parse item price: ",e);
        }
    }

    // tag::withTimeout[]
    public void filterByType(String type) {
        //$("input[name='item_type'][data-path*=" + type +"]");
        withTimeoutOf(15, TimeUnit.SECONDS).find(("a[data-context='item_type'][data-path*=" + type +"]")).click();
                //.then(By.partialLinkText(type)).click();
        //withTimeoutOf(15, TimeUnit.SECONDS).find("#filter-marketplace").then(By.partialLinkText(type)).click();
    }
// end::withTimeout[]

    public int getItemCount() {
        String resultCount = $(".result-count").getText()
                .replace("We found ","")
                .replace(" item","")
                .replace("s","")
                .replace("!","")
                .replace(",","")
                ;
        return Integer.parseInt(resultCount);
    }

    public Optional<String> getSelectedType() {
        List<WebElementFacade> selectedTypes = findAll("a[data-context='item_type'][class*=active]");
        return (selectedTypes.isEmpty()) ? Optional.absent() : Optional.of(selectedTypes.get(0).getText());
    }

    public void filterByLocalRegion() {
        if (containsElements("#filter-location")) {
            withAction().moveToElement($("#filter-location")).perform();
            findAll(".geoname-option a").get(1).click();
        }
    }
// tag::tail[]
}
// end:tail[]
