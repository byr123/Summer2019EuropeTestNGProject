package com.cybertek.tests.day16_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTests extends TestBase {

    @Test
    public void contactDetailsTest(){
        extentLogger = report.createTest("contactDetailsTest");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username:"+username);
        extentLogger.info("password:"+password);
        extentLogger.info("Login as a sales manager");
        loginPage.login(username,password);

        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Navigate to Customer -- Contacts Page");
        contactsPage.navigateToModule("Customers", "Contacts");

        contactsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on mbrackstone9@example.com");

        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String actualFullName = contactInfoPage.fullname.getText();
        String expectedFullName= "Ms Mariam Brackstone";
        extentLogger.info("Verify fullname");
        Assert.assertEquals(actualFullName,expectedFullName,"Verify fullnames");


        String actualEmail = contactInfoPage.email.getText();
        String expectedEmail= "mbrackstone9@example.com";
        extentLogger.info("Verify email");
        Assert.assertEquals(actualEmail,expectedEmail,"Verify email");


        String actualPhone = contactInfoPage.phone.getText();
        String expectedPhone= "+18982323434";
        extentLogger.info("Verify phone");
        Assert.assertEquals(actualPhone,expectedPhone,"Verify phone");


    }



}
