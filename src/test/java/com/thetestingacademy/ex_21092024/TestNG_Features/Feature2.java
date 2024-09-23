package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Feature2 {

//  We have 2 Before Test class But there is no Priority provided to it. TestNG executes them in Alphabetical order

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingID(){
        System.out.println("2");
    }
    @Test
    public void test_PUT(){
        // token and BookingID
        System.out.println("3");
    }

}
