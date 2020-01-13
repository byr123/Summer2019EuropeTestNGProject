package com.cybertek.tests.deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementByPartiallInkText {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://practice.cybertekschool.com");

        //click advanced button
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Amount of all links: " + allLinks.size());

        WebElement link = driver.findElement(By.linkText("Autocomplete"));
        link.click();
        driver.navigate().back();

        WebElement dragAndDropLink = driver.findElement(By.partialLinkText("Drag"));
        dragAndDropLink.click();

        Thread.sleep(2000);
        driver.close();
    }
}
