package com.thetestingacademy.ex_22092024.Assertion_02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest3 {

    @Test
    public void test_verify() {
        String responseName = "pramod";
        Assert.assertEquals("pramod", responseName);
    }
}
