package com.thetestingacademy.ex_15092024.RestAssured.CRUD.POST.TestNGPOST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePOST {
@Test
    public void test_NonBDDStylePOST_using_testng() {

//How Payload is given in Rest Assured
        //  String(1%)
        //  Hashmap(4%)
        //  Classes( 95%)

        String Payload = "     {\n" +
                "        \"username\" : \"admin\",\n" +
                "        \"password\" : \"password123\"\n" +
                "    }";

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/auth");
        request.contentType(ContentType.JSON);
        request.body(Payload);
        request.log().all();


        Response response = request.when().post();

        ValidatableResponse validation = response.then();
        validation.log().all();
        validation.statusCode(200);
    }
}
