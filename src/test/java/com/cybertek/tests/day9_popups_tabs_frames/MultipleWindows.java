package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethods() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void htmlPopUp() {
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Before clicking the link: " + driver.getTitle());

        //clicking "click here" link
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("After clicking the link: " + driver.getTitle());

        //code for switching windows, we have to pass handle
        //driver.switchTo().window()


        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("current window handle = " + currentWindowHandle);

        //after this line, our purpose is switching to new window

        //Set is just like arrayList, but without duplicate values
        Set<String> windowHandles = driver.getWindowHandles();
        //How many different handles it's keeping
        System.out.println(windowHandles.size());

        //Our problem is how can we get new window handle from set of handles. There is no index

        for(String handle : windowHandles){
            if (!currentWindowHandle.equals(handle)){
                driver.switchTo().window(handle);
            }
        }
        System.out.println("After switching: " + driver.getTitle());


    }

    @Test
    public void moreThan2Windows(){

        driver.get("http://practice.cybertekschool.com/windows");

        String targetWindowTitle = "New Window";

        driver.findElement(By.linkText("Click Here")).click();

        //check how many windows we have
        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandles =  driver.getWindowHandles();

        //we will keep switching windows until out title equals to targetWindowTitle.

        for (String handle : windowHandles){

            //switch them one by one

            driver.switchTo().window(handle);

            if (driver.getTitle().equals(targetWindowTitle)){
                //if they are equal stop looping. I want to keep that window driver.
                break;
            }
        }

        System.out.println("After loop title is : " + driver.getTitle());


    }
}