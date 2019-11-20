package com.cybertek.tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.ebay.co.uk/");

        WebElement search = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        search.sendKeys("selenium");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        String result = driver.findElement(By.xpath("//*[@class='srp-controls__count-heading']")).getText();
        System.out.println(result);

        System.out.println("Number of result: " + result.substring(0, result.indexOf(" ")));

    }
}
