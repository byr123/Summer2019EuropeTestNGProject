package com.cybertek.tests.deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByName {

    public static void main(String[] args) throws InterruptedException {   //*[@class='secondary-button small-link']

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cybertekschool.com/multiple_buttons");

        //click advanced button
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        WebElement button2 = driver.findElement(By.name("button2"));
        button2.click();
        Thread.sleep(2000);

        WebElement result =driver.findElement(By.id("result"));
        System.out.println(result.getText());
        driver.close();
    }
}
