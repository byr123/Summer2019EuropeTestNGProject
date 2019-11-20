package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {


    @Test
    public void RadioButton(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        //How to check radio button selected or not ?

        System.out.println("Is blue selected: " + blueRadioButton.isSelected());
        System.out.println("Is red selected: " + redRadioButton.isSelected());


        //Verify that blue button selected
        Assert.assertTrue(blueRadioButton.isSelected(), "Verify that blue button is selected");

        //Verify that red button selected
        Assert.assertFalse(redRadioButton.isSelected(), "Verify that red button selected");

        //How to select radio button?
        System.out.println("Clicking red radio button");
        redRadioButton.click();

        System.out.println("Is blue selected: " + blueRadioButton.isSelected());
        System.out.println("Is red selected: " + redRadioButton.isSelected());

        //Verify blue is not selected
        Assert.assertFalse(blueRadioButton.isSelected(), "Verify blue is not selected");

        //Verify red is selected
        Assert.assertTrue(redRadioButton.isSelected(), "Verify blue is not selected");




        driver.quit();

    }
}
