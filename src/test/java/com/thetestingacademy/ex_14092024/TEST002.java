package com.thetestingacademy.ex_14092024;

import io.restassured.RestAssured;

public class TEST002 {
    public static void main(String[] args) {
        System.out.println("Rest Assured Test CASE");
        System.out.println("GET Request Demo");

        // Gherkins Syntax
//        given() - url, headers, body or paylaod
//        when() - http methods - get, post, patch, put, delete
//        then() - verify the response - er == ar


        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/2").log().all()
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);


    }
}
