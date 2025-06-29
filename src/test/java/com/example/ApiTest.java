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

    @Test
    void getUnknownResource() {
        RestAssured.baseURI = "https://reqres.in";
        given()
        .when()
            .get("/api/unknown/2")
        .then()
            .log().body()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.name", equalTo("fuchsia rose"))
            .body("data.year", equalTo(2001))
            .body("data.color", equalTo("#C74375"))
            .body("data.pantone_value", equalTo("17-2031"))
            .body("support.url", equalTo("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral"))
            .body("support.text", equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."));
    }
}
