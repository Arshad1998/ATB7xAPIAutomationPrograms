package com.thetestingacademy.ex_22092024.PayloadHandling.GSONSerializationDeserialization.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadTest02 {
    // Hashmap Payload

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @Test
    public void test_post_with_hashmap() {

        // {
        //    "firstname" : "sally",
        //    "lastname" : "brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
        //}

        // Let's provide above payload as Hashmap

        // All dat inside {} is a map
        // We are using Linked HAsh map to maintain order

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "sally");
        jsonBodyUsingMap.put("lastname", "brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);


        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        //We are adding this map into the booking dates key of first map
        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);


        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);

//      Adding this Hash map Payload as a body of the request
              /*By default Rest Assured doesn't accept hash ,ap as body it only accepts String
                file, Object, Input Stream
                For Rest Assured to accept Hash map we need to add 2 dependencies which will do serialization
                  1. GSON
                  2, Jackson API

                */

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        // Get validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);


    }
}
