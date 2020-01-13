package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LocatorsPracticeCSS {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/registration_form");

        //click advanced button
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstname.sendKeys("Mike");

        WebElement lastname = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastname.sendKeys("Smith");

        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys("mike@mith.com");

        // to select dropdown
        Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");

        driver.findElement(By.cssSelector("#wooden_spoon")).click();  // click submit button

        Thread.sleep(2000);
        driver.quit();

    }

}
