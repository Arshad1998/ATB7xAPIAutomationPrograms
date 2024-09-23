package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Feature6 {

// When a method requires a parameter/value, we can send it from testng. xml

    @Parameters({"browser1" , "browser2"})
    @Test
    void demo1(String value2, String value1) //Here first value corresponds to first parameter value irrespective of name
    {
        System.out.println("Browser chosen is " +value2);
        // Open the Browser and select dadadada

    }

//  We can create another testng.xml file to have diff browser too
}
