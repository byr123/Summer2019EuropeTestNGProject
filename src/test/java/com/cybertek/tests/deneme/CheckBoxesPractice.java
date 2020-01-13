package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/checkboxes");

        //click advanced button
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[@class='container']//input[1]")).click();
//        driver.findElement(By.xpath("//div[@class='container']//input[2]")).click();
//        Thread.sleep(2000);

        //find all elements with tag name input
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        //loop each list of elements
        for (WebElement checkbox:checkboxes) {
            Thread.sleep(2000);
            //if checkbox is not selected yet
            if (!checkbox.isSelected()){
                //select it
                checkbox.click();
            }
        }

        driver.quit();
    }
}
