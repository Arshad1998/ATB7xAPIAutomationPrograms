package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Feature7 {
//  alwaysRun - will be executed anyway based on the value provided
//  enabled - Test will be skipped or executed based on value provided true or false

    @Test
    public void test01(){
        Assert.assertTrue(false);
    }
    @Test(enabled = true)
    public void test02(){
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "test01", alwaysRun = true)
    public void test03(){
        System.out.println("Depends on test01 but will executed even when it fails");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "test01", enabled = true) //same test03 with enabled but this will not run since test01 fails
    public void test04() {
        System.out.println("Depends on test01 with enabled as true but will not be executed when it fails");
        Assert.assertTrue(true);
    }
}
