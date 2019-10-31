package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getURLAndTitle {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cybertekschool.com");

        // to get title from web page
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        // to getURL of the page
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);


        // to get source codes of the page
        String pageSource = driver.getPageSource();
        System.out.println("Page Source: " + pageSource);

    }
}
