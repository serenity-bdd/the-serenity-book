package net.serenity_bdd.samples.etsy.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenity_bdd.samples.etsy.features.model.ListingItem;
import net.serenity_bdd.samples.etsy.features.steps.serenity.BuyerSteps;
import net.thucydides.core.annotations.Steps;
import static net.serenity_bdd.samples.etsy.features.model.SessionVariables.SELECTED_LISTING;

public class ShoppingCartStepDefinitions {

    @Steps
    BuyerSteps buyer;

    @When("I add the item to the shopping cart")
    public void addCurrentItemToShoppingCart() {
        buyer.selects_any_product_variations();
        buyer.adds_current_item_to_shopping_cart();
    }

    @Then("the item should appear in the cart")
    public void shouldSeeSelectedItemInCart() {
        ListingItem selectedItem = (ListingItem) Serenity.sessionVariableCalled(SELECTED_LISTING);
        buyer.should_see_item_in_cart(selectedItem);
    }

    @Then("the shipping cost should be included in the total price")
    public void shouldIncludeShippingCost() {
        ListingItem selectedItem = (ListingItem) Serenity.sessionVariableCalled(SELECTED_LISTING);
        buyer.should_see_total_including_shipping_for(selectedItem);
    }
}
