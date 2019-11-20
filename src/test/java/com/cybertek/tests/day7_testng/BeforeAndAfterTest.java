package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAndAfterTest {


    @BeforeMethod
    public void setUpMethod(){

        System.out.println("BEFORE METHOD");
        System.out.println("OPENING THE BROWSER");
    }

    @Test
    public void test1(){
        System.out.println("This is my test 1");


    }

    @Test
    public void test2() {
        System.out.println("This is my test 2");

    }


    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD");
        System.out.println("CLOSE THE BROWSER");
    }


    @BeforeClass
    public void beforeEverything(){
        System.out.println("BEFORE CLASS CODE");
    }

    @AfterClass
    public void afterEverything(){
        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTING");    }
}
