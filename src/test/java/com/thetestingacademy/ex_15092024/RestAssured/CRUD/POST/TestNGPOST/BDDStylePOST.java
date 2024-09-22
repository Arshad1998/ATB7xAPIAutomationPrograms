package com.thetestingacademy.ex_15092024.RestAssured.CRUD.POST.TestNGPOST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePOST {

//POST Request

    // URL - https://restful-booker.herokuapp.com/auth

    // BODY - PAYLOAD - JSON
    // {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    // HEADER - Content Type -> application/json

@Test
    public void test_BDDStylePOST_using_testng() {

//How Payload is given in Rest Assured
        //  String(1%)
        //  Hashmap(4%)
        //  Classes( 95%)

        String Payload = "     {\n" +
                "        \"username\" : \"admin\",\n" +
                "        \"password\" : \"password123\"\n" +
                "    }";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(Payload)
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(200);
    }
}
