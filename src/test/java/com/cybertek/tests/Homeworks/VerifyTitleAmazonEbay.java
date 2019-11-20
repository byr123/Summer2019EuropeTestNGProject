package com.cybertek.tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitleAmazonEbay {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String searchItem = "selenium";

        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchItem);
        driver.findElement(By.xpath("//input[@value='Go' and @type='submit']")).click();

        String titleAmazon = driver.getTitle();


        driver.quit();
        Thread.sleep(5000);



        //Go to EBay
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.ebay.co.uk/");

        WebElement search = driver2.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        search.sendKeys(searchItem);

        WebElement submitButton = driver2.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        String titleEbay = driver2.getTitle();

        System.out.println(titleAmazon);
        System.out.println(titleEbay);

        if (titleAmazon.contains(searchItem) && titleEbay.contains(searchItem)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }
}
