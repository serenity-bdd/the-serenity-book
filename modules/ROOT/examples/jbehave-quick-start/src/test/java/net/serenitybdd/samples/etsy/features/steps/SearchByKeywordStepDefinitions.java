package net.serenitybdd.samples.etsy.features.steps;

import net.serenitybdd.samples.etsy.features.steps.serenity.BuyerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

// tag::header[]
public class SearchByKeywordStepDefinitions {
    @Steps
    BuyerSteps buyer;

    // end::header[]
    // tag::woolscenario[]
    @Given("I want to buy $article")
    public void buyerWantsToBuy(String article) {
        buyer.opens_etsy_home_page();
    }

    @When("I have searched for items containing '$keyword'")
    public void searchByKeyword(String keyword) {
        buyer.searches_for_items_containing(keyword);
        buyer.filters_results_to_local_region();
    }

    @When("I search for local items containing '$keyword'")
    public void localSearchByKeyword(String keyword) {
        buyer.searches_for_items_containing(keyword);
    }

    @Then("I should only see items related to '$keyword'")
    public void resultsForACategoryAndKeywordInARegion(String keyword) {
        buyer.should_see_items_related_to(keyword);
    }
    // end::woolscenario[]

    String searchTerm;

    @Given("I have searched for items containing '$keyword'")
    public void buyerHasSearchedFor(String keyword) {
        searchTerm = keyword;
        buyer.opens_etsy_home_page();
        buyer.searches_for_items_containing(keyword);
    }

    @When("I filter results by type '$type'")
    public void filterResultsBy(String type) {
        buyer.filters_results_by_type(type);
    }

    @Then("I should only see items containing '$keyword' of type '$type'")
    public void shouldSeeMatchingFilteredResults(String keyword, String type) {
        buyer.should_see_items_related_to(keyword);
        buyer.should_see_items_of_type(type);
    }

    @When("I select an item")
    public void selectsAnItem() {
        buyer.selects_item_number(1);
    }

    @Then("I should see the corresponding item details")
    public void shouldSeeCorrespondingDetails() {
        buyer.should_see_matching_details(searchTerm);
    }
// tag::tail[]
}
// end::tail[]
