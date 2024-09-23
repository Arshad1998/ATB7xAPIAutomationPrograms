package com.thetestingacademy.ex_21092024.TestNG_Features;

import org.testng.annotations.Test;

public class Feature3 {

//  We have multiple Test Cases arranged with Priority.
    @Test(priority = 1)
    public void t1(){
        System.out.println("1");
    }

    @Test(priority = 0)
    public void t2(){
        System.out.println("3");
    }

    @Test(priority = 3)
    public void t3(){
        System.out.println("2");
    }
}
