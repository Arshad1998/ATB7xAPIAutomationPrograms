package com.thetestingacademy.ex_22092024.JSON_Path;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONPath_01 {
    RequestSpecification request = RestAssured.given();
    Response response;
    ValidatableResponse validate;


    @Test
    public void test_JSONPath1()
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

        response = request.when().post();



//     Import Json Path from Rest Assured

//      3 Steps process to verify response of any API

//       1.Make a Request and get the response
//       2.Extract the data from the response as a String

        System.out.println(response.asString());

        JsonPath jsonpath = new JsonPath(response.asString());
        String BookingId= jsonpath.getString("bookingid");
        String FirstName= jsonpath.getString("booking.firstname");
        String LastName= jsonpath.getString("booking.lastname");
        String AdditionalNeeds= jsonpath.getString("bookingdates.additionalneeds");

        System.out.println(BookingId);
        System.out.println(FirstName);
        System.out.println(LastName);
        System.out.println(AdditionalNeeds);

//      3.Verify the response
        assertThat(BookingId).isNotEmpty().isNotBlank();
        assertThat(FirstName).isNotEmpty().isEqualTo("Mohamed");
        assertThat(LastName).isNotEmpty().isEqualTo("Arshad");






    }

}
