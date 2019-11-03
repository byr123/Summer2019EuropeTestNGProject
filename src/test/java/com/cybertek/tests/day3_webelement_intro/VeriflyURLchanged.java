package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VeriflyURLchanged {

    /**
     * Verify URL changed
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     * enter any email
     * click on Retrieve password
     * verify that url changed to http://practice.cybertekschool.com/email_sent
     */


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any e-mail
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("bay@gmail.com");

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // get current URL
        String currentURL = driver.getCurrentUrl();

        if (currentURL.equals("http://practice.cybertekschool.com/email_senta")) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Actual URL = "+currentURL);

        }

        //close
        driver.quit();
    }
}
