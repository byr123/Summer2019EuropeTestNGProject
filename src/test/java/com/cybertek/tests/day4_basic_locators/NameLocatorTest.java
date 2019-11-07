package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) {
        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize the page
        driver.manage().window().maximize();
        //get the webpage
        driver.get("https://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mike Smith");

        WebElement email =  driver.findElement(By.name("email"));
        email.sendKeys("mikesmith@gmail.com");

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        //verify that you got this message;


        String expectedMessage= "Thank you for signing up. Click the button below to return to the home page";
        String actualMessage = driver.findElement(By.name("signup_message")).getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);


        }

        driver.quit();



    }
}
