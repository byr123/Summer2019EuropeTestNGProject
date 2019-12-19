package com.cybertek.tests.day15_pom_tests;

/*VERIFY RADIO BUTTONS
Open browser
Login as driver
Go to Activities->Calendar
Click on create calendar events
Click on repeat
Verify that repeat every days is checked
verify that repeat weekday is not checked
 */

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    @Test
    public void RepeatRadioButtonTest(){
        //Login as a Driver
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        //Go to Activities->Calendar
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        //Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //if you getting error
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        //Verify that repeat every days is checked
        createCalendarEventsPage.days.isSelected();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify days radiobutton is selected");
        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday radiobutton is not selected");


    }
    /*VERIFY REPEAT OPTIONS
    Open browser
    Login as driver
    Go to Activities->Calendar
    Click on create calendar events
    Click on repeat
    Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)*/

    @Test
    public void verifyRepeatOptions(){
        //Login as a Driver
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        //Go to Activities->Calendar Events

        new DashboardPage().navigateToModule("Activities","Calendar Events");


        //Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //if you getting error
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly","Yearly");
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        //get text of each webelement and return as a list of String
        List<String> actualList = BrowserUtils.getElementsText(actualOptions);

        
        /*List<String> actualList = new ArrayList<>();

        for (WebElement option : actualOptions) {
            //get each webelement text inside the dropdown and add to actual list
            actualList.add(option.getText());
        }*/


        //compare actual and expected list
        Assert.assertEquals(actualList,expectedList,"Compare dropdown values");

    }
}
