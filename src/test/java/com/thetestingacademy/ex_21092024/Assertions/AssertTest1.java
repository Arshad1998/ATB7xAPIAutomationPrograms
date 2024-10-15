package com.thetestingacademy.ex_21092024.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class AssertTest1 {

    RequestSpecification request = RestAssured.given();
    Response response;
    ValidatableResponse validate;


    @Test
    public void test_positive()
    {
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



//  Types of Assertions

//    Rest Assured Default - Hamcrest   // import org.hamcrest.Matchers;

        validate.body("booking.firstname", Matchers.equalTo("Mohamed"));
        validate.body("booking.lastname", Matchers.equalTo("Arshad"));

//   Test NG Assert - Hard Asser and Soft Assert
        Integer BookingId = response.then().extract().path("bookingid");
        String Firstname = response.then().extract().path("booking.firstname");
        Assert.assertNotNull(BookingId);
        Assert.assertEquals(Firstname, "Mohamed");

//  Assertj - import  static org.assertj.core.api.Assertions.*;
        assertThat(BookingId).isPositive().isNotNull().isNotZero();
        assertThat(Firstname).isEqualTo("Mohamed").isNotEmpty().isNotBlank();

    }
}
