package com.cybertek.tests.day6_CssSelector;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cybertekschool.com/multiple_buttons");

        WebElement dontClickButton = driver.findElement(By.cssSelector("#disappearing_button"));

        String message = dontClickButton.getText();

        System.out.println("Message = " + message);
    }
}
