package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");

        //HOW TO SWITCH FRAMES
        driver.switchTo().frame("mce_0_ifr");

        //clear the text inside the box
        driver.findElement(By.id("tinymce")).clear();

        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        //go back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //2. USING INDEX
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).clear();
        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("Mike Mike Mike MIke Mike");


        //go back to first frame, only to parent
        driver.switchTo().parentFrame();


        //3. USING WEB ELEMENT
        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        Thread.sleep(2000);
        //passing frame as a webelement
        driver.switchTo().frame(frameElement);


        driver.findElement(By.id("tinymce")).clear();
        //locate and send some text
        driver.findElement(By.id("tinymce")).sendKeys("We Located with WebElement");

    }


    @Test
    public void multipleFrames(){

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");

        //frame top has 3 children frame, left, middle and right
        //switching to middle frame
        driver.switchTo().frame("frame-middle");
        //get the middle text and print it
        System.out.println(driver.findElement(By.id("content")).getText());


        //go back to parent (top frame) to switch right
        driver.switchTo().parentFrame();

        //switching to right frame
        driver.switchTo().frame(2);

        //print right from right frame
        System.out.println(driver.findElement(By.tagName("body")).getText());


        //go up to top level html directly
        driver.switchTo().defaultContent();

        //switch to frame botton
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go up to top level html directly
        driver.switchTo().defaultContent();

        //switch to frame top
        driver.switchTo().frame(0);

        //switching to right frame
        driver.switchTo().frame(0);

        //print left from right frame
        System.out.println(driver.findElement(By.tagName("body")).getText());


        //GO DIRECTLY
        driver.switchTo().parentFrame().switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());



    }
}
