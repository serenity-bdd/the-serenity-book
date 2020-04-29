package net.serenitybdd.demos.todos.action;

import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * An example of a custom WebDriver Action.
 */
 // tag::class[]
public class JSClick implements Action {

    private final Target target;

    public JSClick(Target target) {
        this.target = target;
    }

    @Override
    @Step("{0} clicks on #target")
    public <T extends Actor> void performAs(T theActor) {
        WebElement targetElement = target.resolveFor(theActor);
        BrowseTheWeb.as(theActor).evaluateJavascript("arguments[0].click()", targetElement);
    }

    public static Action on(Target target) {
        return instrumented(JSClick.class, target);
    }

    private String pathTo(Target target) {
        return target.getCssOrXPathSelector();
    }
}
// end::class[]
