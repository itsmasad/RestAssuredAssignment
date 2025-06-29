package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

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

    @Test
    void registerSuccessful() {
        RestAssured.baseURI = "https://reqres.in";
        String requestBody = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/api/register")
        .then()
            .log().body()
            .statusCode(200)
            .body("id", notNullValue())
            .body("token", notNullValue());
    }
}
