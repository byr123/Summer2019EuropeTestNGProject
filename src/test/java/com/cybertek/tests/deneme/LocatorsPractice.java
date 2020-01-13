package com.cybertek.tests.deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {

    public static void main(String[] args) throws Exception{

        // System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait until element accessible
        driver.get("https://www.google.com/");

        WebElement btn1 = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnI']"));
        String actualText = btn1.getAttribute("value");
        String expectedText = "I'm Feeling Lucky";

        //btn1.click();

        if (actualText.equals(expectedText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);
        }
        Thread.sleep(3000);
        driver.close();

    }
}
