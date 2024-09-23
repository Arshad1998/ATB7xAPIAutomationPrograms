package com.thetestingacademy.ex_21092024.TestNG_IntegrationScenarios;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class IntegrationSC1 {
// Integration Scenario 1
      // Create a Token
      // Create a Booking
      // Perform  a PUT request
      // Verify that PUT is success by GET Request
      // Delete the ID
      // Verify it doesn't exist GET Request

    RequestSpecification request = RestAssured.given();
    Response response;
    ValidatableResponse validate;

    String token = getToken();
    String BookingId = getBookingId();

    @BeforeTest
    public String getToken(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/auth");
        request.contentType(ContentType.JSON);
        request.body(payload);
        request.log().all();

        response = request.when().post();


        validate = response.then().log().all().statusCode(200);

        token=response.jsonPath().getString("token");
        return token;
    }

    @BeforeTest
    public String getBookingId(){
        String PayloadPost = "{\n" +
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

        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking");
        request.contentType(ContentType.JSON);
        request.body(PayloadPost);
        request.log().all();

        response = request.when().post();

        validate = response.then();

        validate.log().all();
        validate.statusCode(200);

        BookingId = response.jsonPath().getString("bookingid");

        return BookingId;
    }

    @Test(priority = 0)
    public void test_PUTReq_UpdateBookingId(){

        String token = getToken();
        String BookingId = getBookingId();

        String PayloadPut = "{\n" +
                "    \"firstname\" : \"Reema\",\n" +
                "    \"lastname\" : \"Farhana\",\n" +
                "    \"totalprice\" : 119,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-09-28\",\n" +
                "        \"checkout\" : \"2024-10-05\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

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

    @Test(priority = 1)
    public void test_Verify_UpdatedBookingID(){

        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/" + BookingId);
        request.log().all();

        response = request.when().get();

        validate = response.then().log().all();
        validate.statusCode(200);

        String firstname = response.jsonPath().get("firstname");
        String lastname = response.jsonPath().get("lastname");

        Assert.assertNotEquals(firstname,"Mohamed");
        Assert.assertNotEquals(lastname,"Arshad");

    }

    @Test(priority = 2)
    public void test_Delete_UpdatedBookingId(){
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/" + BookingId);
        request.contentType(ContentType.JSON);
        request.cookie("token" + token);
//        request.log().all();

        response = request.when().delete();

        validate = response.then();
//        validate.log().all();
        validate.statusCode(201);

    }

    @Test(priority = 3)
    public void test_Verify_If_UpdatedBookingID_Is_Deleted(){

        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/" + BookingId);
        request.log().all();

        response = request.when().get();

        validate = response.then();
        validate.log().all();
        validate.statusCode(404);

    }


}
