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
        return findAll(".order-wrapper")
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
        String name = summaryElement.find(net.serenitybdd.core.annotations.findby.By.tagName("h3")).getText();
        double itemTotal = Double.parseDouble(summaryElement.findBy(".item-total .currency-value").getText());
        double shipping = summaryElement.containsElements(".shipping .currency-value") ?
                Double.parseDouble(summaryElement.findBy(".shipping .currency-value").getText()) : 0.0;

        double grandTotal = summaryElement.containsElements(".grand-total .currency-value")
                ? Double.parseDouble(summaryElement.findBy(".grand-total .currency-value").getText()) : 0.0;

        return new OrderCostSummary(name, itemTotal, shipping, grandTotal);
    }

    public boolean isShowingShippingCosts() {
        return containsElements(".shipping .currency-value");
    }
}
