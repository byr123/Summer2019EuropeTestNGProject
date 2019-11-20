package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class AmazonResultofSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.co.uk/ref=nav_logo");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium");
        driver.findElement(By.xpath("//*[@value='Go']")).click();

        Thread.sleep(2000);
        WebElement searchResult = driver.findElement(By.xpath("//span[contains(text(), 'results for')]"));

        String printResult = searchResult.getText();
        System.out.println(printResult);


        String str =getText(printResult,"1-48 of over ").substring(0,5);
        System.out.println(str);


    }

        public static String getText (String str, String bol){
            String [] arr = str.split(bol);

                return arr[1];

    }
}

