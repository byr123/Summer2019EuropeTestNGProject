package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonsPractice {
    public static void main(String[] args) throws Exception{

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/radio_buttons");

        //click advanced button
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("#yellow")).click();
//        Thread.sleep(2000);

//        driver.findElement(By.cssSelector("#green")).click();
//        System.out.println("Green button is enabled? " + driver.findElement(By.cssSelector("#green")).isEnabled());

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement radio : radioButtons) {
            radio.click();
            System.out.println(radio.getAttribute("id") +" - "+radio.isEnabled());

        }


        //Thread.sleep(2000);
        driver.close();
    }
}
