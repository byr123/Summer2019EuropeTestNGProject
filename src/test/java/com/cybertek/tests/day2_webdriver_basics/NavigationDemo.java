package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        //setting up the browser
        WebDriverManager.chromedriver().setup();

        // selenium object
        WebDriver driver = new ChromeDriver();

        // get URL
        driver.get("https://www.google.com/");

        Thread.sleep(3000);
        //another way open the browser
        driver.navigate().to("https://www.facebook.com/");


        //goes back to previous page
        driver.navigate().back();

        // wait 3 seconds
        Thread.sleep(3000);


        //goes forward page after goes back
        driver.navigate().forward();


        //refresh the page
        driver.navigate().refresh();
    }
}
