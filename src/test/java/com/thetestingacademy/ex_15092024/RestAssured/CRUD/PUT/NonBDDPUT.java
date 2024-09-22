package com.thetestingacademy.ex_15092024.RestAssured.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPUT {
    // Requirements for the PUT request of Restful Booker
    // Existing Booking id -> 6118
    // Token -  Token?
    // Payload - {
    //    "firstname" : "Pramod",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}
//  Process flow of PUT Request
    // POST - Auth - token -> To get Token we need to do Post Request
    // POST - Booking ID - To create id we need to do Post request
    // PUT - token and BookingID _. Then using the created values we can do PUT Request

/*  Two ways to perform this PUT request
     1. We can hardcode the values trequired for the Request
     2. We can perform the 2 POST request to get the values and perform PUT with help of that(API Chaining) */

    RequestSpecification request;
    Response response;
    ValidatableResponse validate;

    @Test
    public void Test_PutRequest_Positive(){

        String token ="6ca8b4d6aed823d";
        String BookingId = "1827";

        String PayloadPut = "{\n" +
                "    \"firstname\" : \"Mohamed\",\n" +
                "    \"lastname\" : \"Arshad\",\n" +
                "    \"totalprice\" : 119,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-09-23\",\n" +
                "        \"checkout\" : \"2024-01-30\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        request = RestAssured.given();

        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/" + BookingId);
        request.contentType(ContentType.JSON);
        request.cookie("token", token); //No need to give "token=" = is by default added
        request.body(PayloadPut);
        request.log().all();

        response = request.when().put();

        validate = response.then();

        validate.log().all();
        validate.statusCode(200);



    }

}
