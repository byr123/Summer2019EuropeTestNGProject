package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CloseAndQuit {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement newTab = driver.findElement(By.linkText("New tab"));
        newTab.click();
    }
}
