package examples.screenplay.rest.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class UserTasks {
    public static Task listAllUsers() {
        return Task.where("{0} lists all users",  // <1>
                Get.resource("/users") // <2>
        );
    }
}
