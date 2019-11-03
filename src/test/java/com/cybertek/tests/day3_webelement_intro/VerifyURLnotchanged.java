package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLnotchanged {

        /**
         * Verify URL not changed
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * click on Retrieve password
         * verify that url did not change
         */

        public static void main(String[] args) {

            // open chrome
            WebDriver driver = WebDriverFactory.getDriver("chrome");

            // go to http://practice.cybertekschool.com/forgot_password
            driver.get("http://practice.cybertekschool.com/forgot_password");

            // save URL to string variable
            String expectedURL = driver.getCurrentUrl();

            //click on Retrieve password
            WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
            retrievePasswordButton.click();

            String actualURL = driver.getCurrentUrl();

            //verify that URL is not change
            if (expectedURL.equals(actualURL)){
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");

            }
            //close the browser
            driver.quit();


    }

}
