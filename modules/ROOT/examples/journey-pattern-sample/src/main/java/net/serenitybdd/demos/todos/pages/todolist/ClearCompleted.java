package net.serenitybdd.demos.todos.pages.todolist;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ClearCompleted extends PageObject {
    public static final Target BUTTON = Target.the("Clear completed button").locatedBy("#clear-completed");
}
