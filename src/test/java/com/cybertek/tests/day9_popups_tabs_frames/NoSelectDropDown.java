package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        Object dropdownMenuLink;
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));
        //open the dropdown
        dropdownElement.click();
        List<WebElement> listofLinks = driver.findElements(By.className("dropdown-item"));

        //size of the list
        System.out.println("Number of links " + listofLinks.size());


        //Print text of each link
        for (WebElement list : listofLinks){
            System.out.println(list.getText());
        }

        //Print of first element in the list
        System.out.println(listofLinks.get(0).getText());


        //locate the element and clicking it
        //driver.findElement(By.linkText("Yahoo")).click();


        //index of the list and click
        listofLinks.get(3).click();
    }
}
