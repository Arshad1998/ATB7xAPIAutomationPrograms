package com.thetestingacademy.ex_21092024.TestNG_Reporting;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG001 {

    @Severity(SeverityLevel.MINOR)
    @Description("Verify If True==True")
    @Test
    public void TestCase01(){
        Assert.assertEquals(true,true);

    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("erify If True==False")
    @Test
    public void TestCase02(){
        Assert.assertEquals(true,true);

//        Allure Report - http://192.168.29.77:58728/index.html
    }
}
