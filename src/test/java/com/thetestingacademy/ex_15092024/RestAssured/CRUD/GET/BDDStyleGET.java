package com.thetestingacademy.ex_15092024.RestAssured.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {

    public static void main(String[] args) {

        // What all required for this GET Request - https://api.zippopotam.us/IN/560037
        // URL
        // HEADER ?
        // GET Method
        // base url = https://api.zippopotam.us
        // basePath = /IN/560037
        // Payload - ? NO
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No

        // Verification
        // Status Code
        // Response Body
        // Time, Headers ,Cookies

        // Gherkin -> Given, When, then -> Style ->

        // BDD - Framework different - Gherkin Syntax - (given, when, then)
        // Non BDD and still Gherkin syntax (using classes)

        // given()
        // URL
        // HEADER ?, Cookies
        // base url = https://api.zippopotam.us
        // basePath = /IN/560037
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No


        // when()
        // PaYLOAD - ? NO/yES - JSON. XML  -> String, Hashmap, Object class
        // GET Method


        // then()
        // Response Validation
        //  Status Code
        //  Response Body
        //  Time, Headers ,Cookies

        System.out.println("Result of Positive TC\n");
        PositiveTest();
        System.out.println("\nResult of Negative TC\n");
        NegativeTest();

    }

    private static void NegativeTest() {
//     Negative Test Case
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/600").log().all()
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(404);
    }

    private static void PositiveTest() {
//     Positive Test Case
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/600019").log().all()
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }


}
