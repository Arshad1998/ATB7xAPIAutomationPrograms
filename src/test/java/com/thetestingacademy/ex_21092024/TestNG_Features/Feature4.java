package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Feature4 {

//  Grouping Test Case with help of tags

    @Test(groups = {"Unit", "QA"})
    public void sanityRun(){
        System.out.println("Sanity Test");
        Assert.assertTrue(true);
    }


    @Test(groups = {"Unit","QA"})
    public void SIT(){
        System.out.println("SIT");
        Assert.assertTrue(true);
    }

    @Test(groups = {"QA","PreProd"})
    public void UAT(){
        System.out.println("UAT");
        Assert.assertTrue(true);
    }

    @Test(groups = {"QA", "Reg"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(true);
    }

}
