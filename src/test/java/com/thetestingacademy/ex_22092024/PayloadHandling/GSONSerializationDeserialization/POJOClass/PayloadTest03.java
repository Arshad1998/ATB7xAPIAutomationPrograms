package com.thetestingacademy.ex_22092024.PayloadHandling.GSONSerializationDeserialization.POJOClass;


import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import static org.assertj.core.api.Assertions.*;

public class PayloadTest03 {

    // Strings
    // Hashmap
    // Class - Pojo -
    // Create class for the Payload - pojo

    // Let's see this concept using POST Request
    // token, booking id

//    {
//                "firstname" : "Jim",
//                        "lastname" : "Brown",
//                    "totalprice" : 111,
//                    "depositpaid" : true,
//                    "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            },
//                "additionalneeds" : "Breakfast"
//            }

@Description("Testing by Passing Payload as a POJO CLass")
@Test
public void test_PayloadViaPOJOClass(){

    Booking booking = new Booking();
    booking.setFirstName("Mohamed");
    booking.setLastName("Arshad");
    booking.setTotalPrice(111);
    booking.setDepositPaid(true);

//  Setting the Inner object in JSON Payload
    BookingDates bookingdates = new BookingDates();
    bookingdates.setCheckIN("2024-10-15");
    bookingdates.setCheckOUT("2024-10-25");

    booking.setBookingdates(bookingdates);

    booking.setAdditionalNeeds("Breakfast");

//    System.out.println(booking);
//    System.out.println(booking.getBookingdates());
//  Above both will print the object in 2 string type

//  Serialization - To convert the JAVA object to String for server we use GSON
    Gson gson = new Gson();
    String JsonStringPayload = gson.toJson(booking);
//    System.out.println(JsonStringPayload);

    RequestSpecification request = RestAssured.given();
    request.baseUri("https://restful-booker.herokuapp.com");
    request.basePath("/booking");
    request.contentType(ContentType.JSON);
    request.body(JsonStringPayload).log().all();


    Response response = request.when().post();

    String ResponseString = response.asString();
    System.out.println(ResponseString);

    ValidatableResponse validation = response.then();
    validation.log().all();
    validation.statusCode(200);

    //DeSerialization - Converting the String back to JSON Object
    //Below code will convert the response which received as a String to object and map it with Booking Response class created

    BookingResponse bookingresponse = gson.fromJson(ResponseString,BookingResponse.class);
    System.out.println("Booking id generated is " + bookingresponse.getBookingid());
    System.out.println("First Name of the Booking generated is " + bookingresponse.getBooking().getFirstName());

    assertThat(bookingresponse.getBooking().getFirstName()).isEqualTo("Mohamed");


    }

}
