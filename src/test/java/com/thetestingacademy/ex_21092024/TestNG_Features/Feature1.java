package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Feature1 {

    // PUT Request Example
      //For PUT Req we need Token and Booking id
      //Hence in Before Test we will have methods to fetch the required value
      //We have 3 Test  Cases for the PUT Request
    String token;
    Integer bookingID;

    @BeforeTest
    public String getToken() {
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenAndBookingID() {
        // POST Req -
        // POST code
        bookingID = 123;
    }


    @Test
    public void testPUTReq() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq2() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq3() {
        System.out.println(token);
        System.out.println(bookingID);
    }
}
