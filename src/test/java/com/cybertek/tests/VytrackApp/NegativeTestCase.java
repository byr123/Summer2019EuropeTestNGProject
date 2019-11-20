package com.cybertek.tests.VytrackApp;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NegativeTestCase {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");


        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user1");

        WebElement password =  driver.findElement(By.id("prependedInput2"));
        password.sendKeys("User345");


        WebElement loginButton =  driver.findElement(By.xpath("//button[1]"));
        loginButton.click();

        Thread.sleep(3000);

        String expectedMessage = "Invalid user name or password.";
        String actualMessage = driver.findElement(By.xpath("//*[text()= 'Invalid user name or password.']")).getText();
        //String actualMessage2 = driver.findElement(By.xpath("//*[contains(text(), 'Invalid')]")).getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Actual Message = " + actualMessage);
        }



        driver.close();
    }
}
