package net.serenitybdd.samples.etsy.features.steps;

import net.serenitybdd.samples.etsy.features.model.ListingItem;
import net.serenitybdd.samples.etsy.features.steps.serenity.BuyerSteps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.samples.etsy.features.model.SessionVariables;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ShoppingCartStepDefinitions {
    @Steps
    BuyerSteps buyer;

    @Given("I have selected an item")
    @When("I select an item")
    public void selectsAnItem() {
        buyer.selects_item_number(1);
    }

    @When("I add the item to the shopping cart")
    public void addCurrentItemToShoppingCart() {
        buyer.selects_any_product_variations();
        buyer.adds_current_item_to_shopping_cart();
    }

    @Then("the item should appear in the cart")
    public void shouldSeeSelectedItemInCart() {
        ListingItem selectedItem = (ListingItem) Serenity.sessionVariableCalled(SessionVariables.SELECTED_LISTING);
        buyer.should_see_item_in_cart(selectedItem);
    }

    @Then("the shipping cost should be included in the total price")
    public void shouldIncludeShippingCost() {
        ListingItem selectedItem = (ListingItem) Serenity.sessionVariableCalled(SessionVariables.SELECTED_LISTING);
        buyer.should_see_total_including_shipping_for(selectedItem);
    }
}
