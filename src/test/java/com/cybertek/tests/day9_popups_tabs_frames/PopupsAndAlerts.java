package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




    @Test
    public void htmlPopUp(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //locating and clicking destroy button
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();

        //locating NO button and clicking it
        driver.findElement(By.xpath("//*[text()='No']")).click();

    }


    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //locating and clicking for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();

        //controlling alert using with Alert class
        Alert alert =  driver.switchTo().alert(); // You can use  accept,dismiss,sendKeys, getText with Alert
        Thread.sleep(2000);
        //clicking alert --->clicking OK in the alerts
        alert.accept();

        //Clicking for JS Confirm
        driver.findElement(By.xpath("//button[2]")).click();

        //Clicking x to close, selecting no/cancel
        alert.dismiss();
        Thread.sleep(2000);

        //Clicking for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);

        //sendKeys() ---> send some keys
        alert.sendKeys("Mike Smith");
        //When we send the text, we might not see the text in the input box.
        Thread.sleep(2000);



    }
}
