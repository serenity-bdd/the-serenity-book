package examples.screenplay.rest;

import examples.screenplay.rest.model.User;
import examples.screenplay.rest.tasks.FindAUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

import static examples.screenplay.rest.tasks.UserTasks.listAllUsers;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class WhenManagingUsers {


    // tag::setup[]
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables; // <1>
    private Actor sam; // <2>

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl") // <3>
                                                       .orElse("https://reqres.in/api");

        sam = Actor.named("Sam the supervisor").whoCan(CallAnApi.at(theRestApiBaseUrl)); // <4>
    }
    // end::setup[]

    // tag::list_all_users[]
    @Test
    public void list_all_users() {

        Actor sam = Actor.named("Sam the supervisor")
                         .whoCan(CallAnApi.at(theRestApiBaseUrl));

        sam.attemptsTo(
                Get.resource("/users")
        );

        sam.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.statusCode(200)
                                            .body("data.first_name", hasItems("George", "Janet", "Emma")))
        );
    }
    // end::list_all_users[]



    @Test
    public void fetch_every_user() {

        // tag::fetch_every_user[]
        sam.attemptsTo(
                Get.resource("/users") // <1>
        );

        sam.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.body("data.first_name", hasItems("George", "Janet", "Emma"))) // <2>
        );
        // end::fetch_every_user[]

        // tag::fetch_every_user_data[]
        List<String> userSurnames = SerenityRest.lastResponse().path("data.last_name"); // <1>
        assertThat(userSurnames).contains("Bluth", "Weaver", "Wong");
        // end::fetch_every_user_data[]

        // tag::fetch_every_user_object[]
        List<User> users = SerenityRest.lastResponse()
                                       .jsonPath()
                                       .getList("data", User.class); // <1>

        assertThat(users).hasSize(3);
        // end::fetch_every_user_object[]

    }

    @Test
    public void fetch_every_user_as_maps() {

        sam.attemptsTo(
                Get.resource("/users") // <1>
        );

        sam.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.body("data.first_name", hasItems("George", "Janet", "Emma"))) // <2>
        );

        List<String> userSurnames = SerenityRest.lastResponse().path("data.last_name"); // <1>
        assertThat(userSurnames).contains("Bluth", "Weaver", "Wong");

        List<Map<String,String>> users = SerenityRest.lastResponse()
                .jsonPath()
                .get("data"); // <1>

        assertThat(users).hasSize(3);

    }


    @Test
    public void list_all_users_with_task() {

        Actor sam = Actor.named("Sam the supervisor")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));

        // tag::list_all_users_with_task[]
        sam.attemptsTo(
                listAllUsers()
        );
        // end::list_all_users_with_task[]

        sam.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.statusCode(200)
                                .body("data.first_name", hasItems("George", "Janet", "Emma")))
        );
    }


    // tag::find_an_individual_user[]
    @Test
    public void find_an_individual_user() {

        sam.attemptsTo(
                Get.resource("/users/1") // <1>
        );

        sam.should(
                seeThatResponse( "User details should be correct", // <2>
                        response -> response.statusCode(200) // <3>
                                            .body("data.first_name", equalTo("George")) // <4>
                                            .body("data.last_name", equalTo("Bluth")) // <5>
                )
        );
    }
    // end::find_an_individual_user[]

    @Test
    public void find_an_individual_user_by_id() {

        // tag::find_an_individual_user_via_a_task[]
        sam.attemptsTo(
                FindAUser.withId(1)
        );
        // end::find_an_individual_user_via_a_task[]

        sam.should(
                seeThatResponse( "User details should be correct", // <2>
                        response -> response.statusCode(200) // <3>
                                .body("data.first_name", equalTo("George")) // <4>
                                .body("data.last_name", equalTo("Bluth")) // <5>
                )
        );
    }

    // tag::retrieve_user_details[]
    @Test
    public void retrieve_an_element_from_the_json_structure() {

        sam.attemptsTo(
                Get.resource("/users/1")
        );

        User user = SerenityRest.lastResponse() // <1>
                                .jsonPath()
                                .getObject("data", User.class); // <2>

        assertThat(user.getFirstName()).isEqualTo("George");
        assertThat(user.getLastName()).isEqualTo("Bluth");

    }
    // end::retrieve_user_details[]

    @Test
    public void retrieve_a_user_using_path_parameters() {

        // tag::path_parameters[]
        sam.attemptsTo(
                Get.resource("/users/{id}").with( request -> request.pathParam("id", 1)) // <1>
        );
        // end::path_parameters[]

        sam.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.body("data.first_name",
                                             equalTo("George")))
        );
    }

    @Test
    public void retrieve_next_page_of_results() {

        // tag::query_parameters[]
        sam.attemptsTo(
                Get.resource("/users").with( request -> request.queryParam("page", 2)) // <1>
        );

        sam.should(
                seeThatResponse("All users on page 2 should be returned",
                        response -> response.body("data.first_name",
                                             hasItems("Eve", "Charles", "Tracey"))) // <2>
        );
        // end::query_parameters[]
    }

    @Test
    public void user_not_found() {

        sam.attemptsTo(
                Get.resource("/users/99")
        );

        sam.should(
                seeThatResponse(response -> response.statusCode(404))
        );
    }

    @Test
    public void add_a_new_user() {

        // tag::add_a_new_user[]
        sam.attemptsTo(
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json") // <1>
                                                .body("{\"firstName\": \"Sarah-Jane\",\"lastName\": \"Smith\"}") // <2>
                        )
        );

        sam.should(
                seeThatResponse("The user should have been successfully added",
                                response -> response.statusCode(201))
        );
        // end::add_a_new_user[]
    }

    @Test
    public void add_a_new_user_as_an_object() {

        // tag::add_a_new_user_as_an_object[]
        User newUser = new User("Sarah-Jane", "Smith");

        sam.attemptsTo(
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                                .body(newUser) // <1>
                        )
        );
        // end::add_a_new_user_as_an_object[]

        sam.should(
                seeThatResponse("The user should have been successfully added",
                        response -> response.statusCode(201))
        );
    }


    @Test
    public void update_a_user() {

        // tag::update_a_user[]
        sam.attemptsTo(
                Put.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"firstName\": \"jack\",\"lastName\": \"smith\"}")
                        )
        );

        sam.should(
                seeThatResponse(response -> response.statusCode(200)
                                                    .body("updatedAt", not(isEmptyString())))
        );
        // end::update_a_user[]
    }

    @Test
    public void delete_a_user() {

        // tag::delete_a_user[]
        sam.attemptsTo(
                Delete.from("/users/1")
        );

        sam.should(
                seeThatResponse(response -> response.statusCode(204))
        );
        // end::delete_a_user[]
    }

    @Test
    public void login() {

        // tag::login[]
        sam.attemptsTo(
                Post.to("/login")
                        .with(request -> request.header("Content-Type", "application/json")
                                                .body("{\"email\": \"peter@klaven\",\"password\": \"cityslicka\"}")
                        )
        );

        String token = SerenityRest.lastResponse().jsonPath().get("token"); // <1>

        assertThat(token).isEqualTo("QpwL5tke4Pnpja7X");
        // end::login[]
    }
}
