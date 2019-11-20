package com.cybertek.tests.day7_testng;

import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test  // ---> annotation
    public void test1(){
        System.out.println("My first TestNG Test");

    }

    @Test
    public void test2(){
        System.out.println("My second TestNg Test");
    }
}
