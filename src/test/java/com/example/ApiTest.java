package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    /**
     * Simple test for the GET users endpoint.
     * <p>
     * Sends a request to <code>/api/users?page=2</code> and verifies that the
     * service responds with HTTP 200 and that the returned page number is 2.
     */
    @Test
    void getUsersPage2() {
        // Base URI used for all requests
        RestAssured.baseURI = "https://reqres.in";

        // Perform GET request with query parameter "page=2"
        given()
            .queryParam("page", 2)
        .when()
            .get("/api/users")
        .then()
            .log().body()            // Log the body for debugging
            .statusCode(200)        // Verify HTTP status is 200 OK
            .body("page", equalTo(2)); // Assert that the page field equals 2
    }

    /**
     * Example POST request to create a user.
     *
     * Sends the JSON payload <code>{"name":"morpheus","job":"leader"}</code>
     * to <code>/api/users</code> and expects HTTP 201 in response.
     */
    @Test
    void createUser() {
        RestAssured.baseURI = "https://reqres.in";

        // JSON body to send in the request
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        // Perform POST request with the body and validate the response
        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .log().body()
            .statusCode(201)        // Expect HTTP 201 Created
            .body("name", equalTo("morpheus"))
            .body("job", equalTo("leader"));
    }
}
