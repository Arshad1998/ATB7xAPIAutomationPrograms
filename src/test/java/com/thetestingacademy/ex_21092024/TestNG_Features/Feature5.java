package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Feature5 {

//    DependsOnMethod - Indicates the Method required for the method to execute

    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
//        Assert.assertTrue(false);
    }

//  If serverStartedOk is failed then method1 will not be executed
    @Test(dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("method1");
    }
}
