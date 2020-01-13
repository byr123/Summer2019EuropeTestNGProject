package com.cybertek.tests.Homeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase_4 extends TestBase {


    @Test
    public void hoverOnThreeDotsTest1() throws InterruptedException {
        extentLogger = report.createTest("Verify that view,edit,delete options are available");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store  manager");
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Navigate to Activities - Calendar Events Page");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Hover over ...  for TesterMeeting");


        action.moveToElement(calendarEventsPage.threeDots).perform();
        //System.out.println(calendarEventsPage.threeDots.getText());  // prints ...

        // Verify that view-edit-delete options are available
        soft.assertTrue(calendarEventsPage.delete.isDisplayed());
        soft.assertTrue(calendarEventsPage.edit.isDisplayed());
        soft.assertTrue(calendarEventsPage.view.isDisplayed());
        extentLogger.info("Assert view, edit and delete displayed");

        soft.assertAll();
        extentLogger.pass("Verified view, edit and delete displayed");

    }

    @Test
    public void gridOptionsTest2() throws InterruptedException {
        extentLogger = report.createTest("Verify that Title column still displayed");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        Thread.sleep(2000);
        calendarEventsPage.gridSettings.click();
        extentLogger.info("Click on Grid Settings options");

        List<WebElement> grids = driver.findElements(By.xpath("//table//tbody/tr/td[3]/input"));

        for (int i = 1; i < 7; i++) {
            grids.get(i).click();

        }
        WebElement titleText = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][contains(.,'Title')]"));
        Assert.assertTrue(titleText.isDisplayed());
        extentLogger.info("Verify that Title column is displayed");


    }

    @Test
    public void SaveAndCloseOptionsTest3() throws InterruptedException {
        extentLogger = report.createTest("Verify that Save and Close, Save and New and Save options are available");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");


        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        Thread.sleep(2000);
        createCalendarEventsPage.saveAndCloseExpandButton.click();
        Thread.sleep(2000);
        extentLogger.info("Expand Save and Close button");

        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']"));
        boolean available = false;
        for (WebElement each : options) {
            available = each.isEnabled();
        }
        Assert.assertTrue(available, "Verify that options are available");
        extentLogger.info("Verify that options are available");

    }

    @Test
    public void CancelButtonTest4() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.cancelButton.click();
        extentLogger.info("Click Cancel button");

        boolean subtitle = createCalendarEventsPage.saveAndCloseExpandButton.isDisplayed();
        Assert.assertTrue(subtitle);
        extentLogger.pass("PASS: Verify that All Calendar Events page subtitle is displayed");

    }

    @Test
    public void EndAndStartTimeTest5() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        String[] start = createCalendarEventsPage.startTime.getAttribute("value").split(":");
        String[] end = createCalendarEventsPage.endTime.getAttribute("value").split(":");
        int actualDifference = Integer.valueOf(end[0]) - Integer.valueOf(start[0]);
        extentLogger.info("Verify that difference between end time and start time is exactly 1 hour");

        Assert.assertEquals(actualDifference, 1);
        extentLogger.pass("PASS: Verify that difference between end time and start time is exactly 1 hour");

    }

    @Test
    public void EndTimeTenPMTest6() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.startTime.click();
        extentLogger.info("Click start time");

        driver.findElement(By.xpath("//li[contains(.,'9:00 PM')]")).click();
        extentLogger.info("Click 9:00 PM");
        Thread.sleep(2000);

        boolean end = createCalendarEventsPage.endTime.getAttribute("value").contains("10:00 PM");
        Assert.assertEquals(end, true);
        extentLogger.pass("Verify that end time is displayed 10: 00 PM");

    }

    @Test
    public void AllDayEventTest7() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.allDayEvent.click();
        extentLogger.info("Select All Day Event checkbox");

        // Verify that All-Day-Event checkbox is displayed
        //Verify that start and end time input boxes are not displayed
        //Verify that start and end date input boxes are displayed
        soft.assertTrue(createCalendarEventsPage.allDayEvent.isSelected());
        extentLogger.info("Verify that All-Day-Event checkbox is displayed");
        soft.assertFalse(createCalendarEventsPage.startTime.isDisplayed() & createCalendarEventsPage.endTime.isDisplayed());
        extentLogger.info("Verify that start and end time input boxes are not displayed");
        soft.assertTrue(createCalendarEventsPage.startDate.isDisplayed() & createCalendarEventsPage.endDate.isDisplayed());
        extentLogger.info("Verify that start and end date input boxes are displayed");

        //soft.assertAll();
        extentLogger.pass("Verified displayed or not displayed some sections");

    }

    @Test
    public void RepeatCheckBoxTest8() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click Repeat checkbox");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        extentLogger.info("Verify that Repeat checkbox is selected");
        Assert.assertTrue(createCalendarEventsPage.repeatOptions.getAttribute("value").equalsIgnoreCase("daily"));
        extentLogger.info("Verify that Daily is selected by default");

        //create expected List
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        //create actual List
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        //create actual String ArrayList to add the options
        List<String> actualList = new ArrayList<>();
        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
        }

        Assert.assertEquals(actualList, expectedList);
        extentLogger.info("Verify that dropdown options are equal with expected");
        extentLogger.pass("Verified all steps");

    }

    @Test
    public void RepeatEveryRadioButtonTest9() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click Repeat checkbox");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        extentLogger.info("Verify that Repeat checkbox is selected");

        Assert.assertTrue(createCalendarEventsPage.repeatEvery.isSelected());
        extentLogger.info("Verify that Repeat Every radio button is selected");

        Assert.assertTrue(createCalendarEventsPage.never.isSelected());
        extentLogger.info("Verify that Never radio button is selected");

        Assert.assertEquals(createCalendarEventsPage.summaryMessage.getText(), "Daily every 1 day");
        extentLogger.info("Verify Daily every 1 day message is displayed as a summery");

        extentLogger.pass("All steps are verified");

    }

    @Test
    public void AfterButtonTest10() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click Repeat checkbox");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        extentLogger.info("Verify that Repeat checkbox is selected");

        createCalendarEventsPage.after.click();
        extentLogger.info("Verify that after checkbox is selected");
        createCalendarEventsPage.afterInputBox.sendKeys("10");
        extentLogger.info("Verify after 10 occurrences is typed");
        Thread.sleep(2000);
        createCalendarEventsPage.afterInputBox.click();

        String text1 = driver.findElement(By.xpath("//*[text()='Daily every 1 day']")).getText();
        String text2 = driver.findElement(By.xpath("//*[text()=', end after 10 occurrences']")).getText();
        String actualMessage = text1.concat(text2);
        extentLogger.info("The full message has been located");
        String expectedMessage = "Daily every 1 day, end after 10 occurrences";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.info("Verify the actual message is equal to expected message");
        extentLogger.pass("PASS: All steps has been verified");

    }

    @Test
    public void AfterButtonTest11() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click Repeat checkbox");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        extentLogger.info("Verify that Repeat checkbox is selected");

        createCalendarEventsPage.by.click();
        extentLogger.info("Select By option");
        createCalendarEventsPage.byInputBox.sendKeys("Nov 18, 2021");
        extentLogger.info("Type into the By input box Nov 18, 2021");

        String text1 = driver.findElement(By.xpath("//*[text()='Daily every 1 day']")).getText();
        String text2 = driver.findElement(By.xpath("//*[text()=', end by Nov 18, 2021']")).getText();
        String actualMessage = text1.concat(text2);
        extentLogger.info("The full message has been located");
        String expectedMessage = "Daily every 1 day, end by Nov 18, 2021";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.info("Verify the actual message is equal to expected message");
        extentLogger.pass("PASS: All steps has been verified");
    }

    @Test
    public void WeeklyOptionTest12() throws InterruptedException {
        extentLogger = report.createTest("Verify that All Calendar Events page subtitle is displayed");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a store  manager");

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        loginPage.login(username, password);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to Calendar Events page");

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Event button");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Click Repeat checkbox");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        extentLogger.info("Verify that Repeat checkbox is selected");

        Select select = new Select(createCalendarEventsPage.repeatOptions);
        select.selectByVisibleText("Weekly");
        extentLogger.info("Select Weekly options as a repeat option");

        createCalendarEventsPage.repeatOnMonday.click();
        createCalendarEventsPage.repeatOnFriday.click();
        extentLogger.info("Select Monday and Friday options");

        //Verify that following message is displayed
        WebElement actualMessage = driver.findElement(By.xpath("//span[(text()='Weekly every 1 week on Monday, Friday')]"));
        extentLogger.info("The actual message has been located");
        System.out.println(actualMessage.getText());
        Assert.assertTrue(actualMessage.isDisplayed());
        extentLogger.info("Verify the actual message is displayed");
        extentLogger.pass("PASS: All steps has been verified");
    }
}