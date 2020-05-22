package net.serenitybdd.demos.todos.pages.todolist.counter;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TodoCounter extends PageObject {
    public static Target ITEM_COUNT =  Target.the("todo count").locatedBy("#todo-count strong");
}
