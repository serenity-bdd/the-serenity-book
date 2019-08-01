package net.serenity_bdd.samples.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenity_bdd.samples.etsy.pages.ResultsPage;
import net.serenity_bdd.samples.etsy.pages.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    SearchPage searchPage;
    ResultsPage resultsPage;

    @Given("Serge is on the Search page")
    public void serge_is_on_the_Search_page() {
        searchPage.open();
    }

    @When("he searches by {string}")
    public void he_searches_by(String keyword) {
        searchPage.searchBy(keyword);
    }

    @Then("he should only see search results containing the word {string}")
    public void he_should_only_see_search_results_containing_the_word(String expectedKeyword) {
        resultsPage.getSearchResultTitles().forEach(
                title -> assertThat(title).containsIgnoringCase(expectedKeyword)
        );
    }
}
