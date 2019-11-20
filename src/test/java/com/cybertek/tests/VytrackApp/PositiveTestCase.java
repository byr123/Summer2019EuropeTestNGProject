package com.cybertek.tests.VytrackApp;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PositiveTestCase {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");


        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.xpath("//button[1]")).click();

        Thread.sleep(3000);

        String expectedUrl = "https://qa1.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

        }

        Thread.sleep(3000);





        //driver.quit();
    }
}
