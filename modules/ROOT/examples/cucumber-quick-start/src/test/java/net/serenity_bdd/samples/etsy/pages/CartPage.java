package net.serenity_bdd.samples.etsy.pages;

import net.serenity_bdd.samples.etsy.features.model.ListingItem;
import net.serenity_bdd.samples.etsy.features.model.OrderCostSummary;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CartPage extends PageObject {

    public List<OrderCostSummary> getOrderCostSummaries() {
        return findAll(".multi-shop-cart")
                .stream()
                .map(CartPage::convertToOrderCostSummary)
                .collect(Collectors.toList());
    }

    public Optional<OrderCostSummary> getOrderCostSummaryFor(ListingItem selectedItem) {
        return getOrderCostSummaries()
                .stream()
                .filter(item -> item.getName().equals(selectedItem.getName()))
                .findFirst();
    }

    public static OrderCostSummary convertToOrderCostSummary(WebElementFacade summaryElement) {
        String name = summaryElement.find(net.serenitybdd.core.annotations.findby.By.className("listing-title")).getAttribute("title");
        double itemTotal = Double.parseDouble(summaryElement.findBy(".multi-shop-cart-single .currency-value").getAttribute("innerText"));
        return new OrderCostSummary(name, itemTotal);
    }
}
