package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy (xpath = "//td[contains(.,'Nov 27, 2019, 9:30 AM')]/..//td[@class='action-cell grid-cell grid-body-cell']")
    public WebElement threeDots;

    @FindBy(xpath = "//a[@href='/calendar/event/update/273']/../..//li[3]/a")
    public WebElement delete;

    @FindBy(xpath = "//a[@href='/calendar/event/view/273']")
    public WebElement view;

    @FindBy(xpath = "//a[@href='/calendar/event/update/273']")
    public WebElement edit;

    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridSettings;



}