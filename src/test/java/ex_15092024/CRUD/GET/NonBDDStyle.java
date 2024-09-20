package ex_15092024.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {

//  Static methods using this reference hence this should be static
    static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
//     r.useRelaxedHTTPSValidation("TLS""); - We can use this is there is HTTPs related issued
        r.baseUri("https://api.zippopotam.us");
        TestPositiveNonBDD();
        TestNegativeNonBDD();


    }

    private static void TestNegativeNonBDD() {

        r.basePath("/IN/600019").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    private static void TestPositiveNonBDD() {

        r.basePath("/IN/600019").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
}

