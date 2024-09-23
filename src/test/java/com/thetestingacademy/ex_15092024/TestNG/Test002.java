package com.thetestingacademy.ex_15092024.TestNG;

import org.testng.annotations.*;

public class Test002 {

    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
    }
    @BeforeClass
    void demo2(){
        System.out.println("Before Class");
    }
    @BeforeTest
    void demo3(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    void demo8(){
        System.out.println("Before Method");
    }
    @Test
    void demo4(){
        System.out.println("Test");
    }
    
    @AfterMethod
    void demo9(){
        System.out.println("After Method");
    }
    @AfterTest
    void demo5(){
        System.out.println("After Test");
    }
    @AfterClass
    void demo6(){
        System.out.println("After Class");
    }
    @AfterSuite
    void demo7(){
        System.out.println("After Suite");
    }

}
