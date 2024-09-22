package com.thetestingacademy.ex_14092024;

public class BuilderPatternDesign {

    // Change return type of each method as Class type
    // "this" always points to current/calling object. Returning the same to
    // have same reference

    public BuilderPatternDesign Floor1() {
        System.out.println("Floor 1");
        return this;
    }

    public BuilderPatternDesign Floor2(String name) {
        System.out.println(name);
        return this;
    }

    public BuilderPatternDesign Floor3() {
        System.out.println("Floor 3");
        return this;
    }


    public static void main(String[] args) {
        BuilderPatternDesign bp = new BuilderPatternDesign();

        bp.Floor1().Floor2("Floor 2").Floor3();
        System.out.println();
        bp.Floor2("Floor 2").Floor3().Floor1();

//If the function are declared as Static we can directly call them using class name - The same happening with RetAssured(Test 002)


    }


}
