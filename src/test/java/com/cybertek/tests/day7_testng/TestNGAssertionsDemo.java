package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {


    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals(1,23);

        System.out.println("Second Assertion");
        Assert.assertEquals("title", "title");

        System.out.println("after second assertion");

    }

    @Test
    public void test2(){
            // verify that title starts with C
        String actualTitle = "Cybertek";
        String expectedTitleBeginning = "B";

        System.out.println("first assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitleBeginning),"Verify title starts with C");


    }
        //TASK
        //verify that email includes @ sign

    @Test
    public void test3(){

        String email = "email@email.com";
        String sign = "@";
        Assert.assertTrue(email.contains(sign), "Verify @ in email");

    }

    @Test
    public void test4(){

        // verify that two values are not equal together
        Assert.assertNotEquals("one", "two");
    }

    @Test
    public void test5(){

        // verify that the condition is not true
        Assert.assertFalse(1<0);
    }

}
