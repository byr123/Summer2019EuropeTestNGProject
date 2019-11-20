package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement signUpButton = driver.findElement(By.xpath("//button[.='Sign Up']"));
        signUpButton.click();

        driver.navigate().back();

        WebElement signUpPageText = driver.findElement(By.xpath("//*[.='Sign Up Page']"));
        System.out.println(signUpPageText.getText());

        WebElement searchElement = driver.findElement(By.xpath("//*[@value=\"Go\"]"));
        WebElement searchElement2 = driver.findElement(By.xpath(""));




    }
}
