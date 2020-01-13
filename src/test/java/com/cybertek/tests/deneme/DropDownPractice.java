package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{

        //selectByTextTest();
        //selectByValueTest();
        //selectByIndex();
        //multiSelectDropDownTest();
        nonSelectDopDownTest();

    }

    public static void setup() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://practice.cybertekschool.com/dropdown");

        //click advanced button
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    public static void selectByTextTest() throws Exception {
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        driver.close();
    }

    public static void selectByValueTest() throws Exception{
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("DC");
        Thread.sleep(2000);
        String expected = "District Of Columbia";
        String actual = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actual,expected,"Verify that state is equal");
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);
        driver.close();

    }

    public static void selectByIndex() throws Exception{
        setup();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(1);
        Thread.sleep(2000);

        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actual,expected,"Verify that index is equal");
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);
        driver.close();
    }

    public static void multiSelectDropDownTest() throws Exception{
        setup();
        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> options = select.getOptions();
        for (WebElement eachOption : options){
            Thread.sleep(1000);
            select.selectByVisibleText(eachOption.getText());
            System.out.println(eachOption.getText());
        }

        Thread.sleep(1000);

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement option : selectedOptions){
            System.out.println(option.getText());
        }
        select.deselectAll();
        driver.close();

    }

    public static void nonSelectDopDownTest() throws Exception {
        setup();
        WebElement dropdown = driver.findElement(By.id("dropdownMenuLink"));
        WebElement optionAmazon = driver.findElement(By.xpath("//a[text()='Amazon']"));

        dropdown.click();
        Thread.sleep(1000);
        optionAmazon.click();
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}
