package com.thetestingacademy.ex_15092024.RestAssured.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGET {

/*  If you declare r inside the main method, each test method would need its own copy of RequestSpecification, which
     defeats the purpose of centralizing the configuration and could lead to redundancy*/

    static RequestSpecification r = RestAssured.given(); //Static methods can access only static fields hence using this should be static

    public static void main(String[] args) {
//     r.relaxedHTTPSValidation("TLS"); - We can use this is there is HTTPs related issued
        r.baseUri("https://api.zippopotam.us");

//        NonBDDStyle nbd = new NonBDDStyle(); //We can do this if we need to avoid static (Mentioned just for understanding )
//        nbd.TestPositiveNonBDD();

        TestPositiveNonBDD();
        TestNegativeNonBDD();

    }

    private static void TestNegativeNonBDD() {

        r.basePath("/IN/600019").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    private static void TestPositiveNonBDD() //We can remove static here if we use ref for Non BDD Style class
    {

        r.basePath("/IN/600019").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
}

