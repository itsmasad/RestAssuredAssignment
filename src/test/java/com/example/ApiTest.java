package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    void getUsersPage2() {
        RestAssured.baseURI = "https://reqres.in";
        given()
            .queryParam("page", 2)
        .when()
            .get("/api/users")
        .then()
            .log().body()
            .statusCode(200)
            .body("page", equalTo(2));
    }
}
