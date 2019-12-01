package com.cybertek.tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");

        WebElement searchItem = driver.findElement(By.id("searchInput"));
        searchItem.sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@title='Selenium (software)']")).click();

        //Verify URL ends with "Selenium_(software)"

        String endsURL = "Selenium_(software)";
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.endsWith(endsURL)) {
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");

        }
         System.out.println("Current URL = " + currentUrl);


        Thread.sleep(3000);
        driver.close();

    }
}
