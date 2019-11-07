package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //get webpage
        driver.get("https://practice.cybertekschool.com/sign_up");

        //enter full name
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith With Tagname");

        //enter email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@gmail.com");

        WebElement signUpButton = driver.findElement(By.tagName("button"));
        signUpButton.click();

        //print the message using tagName locator
        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(message.getText());



    }
}
