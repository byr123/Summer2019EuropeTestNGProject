package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();

        List<WebElement> buttons = driver.findElements(By.tagName("button"));


        System.out.println("buttons.size() = " + buttons.size());

        //Verify that you got 6 element
        Assert.assertEquals(buttons.size(),6,"Verify we got 6 buttons");

        //each element get text

        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }

        for (int i=0; i< buttons.size() ; i++){
            System.out.println(buttons.get(i).getText());
        }


    }


    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();


        //Wrong locator but we are not getting any error, we are getting empty List
        List<WebElement> buttons = driver.findElements(By.tagName("gbjngjk"));
        System.out.println(buttons.size());

    }
}
