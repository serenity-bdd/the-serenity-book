package net.serenity_bdd.samples.etsy.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends PageObject {

    public List<String> getSearchResultTitles() {
        return findAll(".results .result__title")
                .stream()
                .map(WebElementFacade::getTextContent)
                .collect(Collectors.toList());
    }
}
