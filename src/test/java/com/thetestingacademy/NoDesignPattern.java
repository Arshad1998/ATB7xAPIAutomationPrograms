package com.thetestingacademy;

public class NoDesignPattern {

    public void Step1(){
        System.out.println("Step 1");
    }

    public void Step2(String name){
        System.out.println(name);
    }
    public void Step3(){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {

        NoDesignPattern np = new NoDesignPattern();
        np.Step1();
        np.Step2("Step 2");
        np.Step3();

    }
}
