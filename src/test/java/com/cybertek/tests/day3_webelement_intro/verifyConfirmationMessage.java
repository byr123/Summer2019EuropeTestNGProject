package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    /**
     * Verify confirmation message
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     * enter any email
     * verify that email is displayed in the input box
     * click on Retrieve password
     * verify that confirmation message says 'Your e-mail's been sent!'
     * @param args
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "email@email.com";
        emailInputBox.sendKeys(expectedEmail);

        //verify that email is displayed in the input box
        //getting text from webelements
        //getText()
        //getAttribute()
        String actualEmail = emailInputBox.getAttribute("value");


        if (expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected email = " + expectedEmail);
            System.out.println("Actual email = " + actualEmail);
        }

        //retrievePasswordButton
        driver.findElement(By.id("form_submit")).click();

        //verify that confirmation message says 'Your e-mail's been sent!'

        String expectedMessage =  "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected Message = " + expectedMessage);
            System.out.println("Actual Message = " + actualMessage);
        }




        driver.quit();

    }
}
