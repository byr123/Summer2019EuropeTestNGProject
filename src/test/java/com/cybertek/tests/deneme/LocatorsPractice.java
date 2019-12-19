package com.cybertek.tests.deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {

    public static void main(String[] args) {

        // System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait until element accessible
        driver.get("https://www.google.com/");

    }
}
