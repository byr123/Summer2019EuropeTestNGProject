package com.cybertek.tests.day15_extent_report;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest(){
        //name of the test for report
        extentLogger = report.createTest("Wrong Password Test");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password");
        loginPage.loginBtn.click();
        extentLogger.info("Click login button");
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        //we put after assertion so if the assertion fails, it will not send pass to report
        extentLogger.pass("PASS:Wrong Password Test");
    }
    @Test
    public void wrongUsername(){
        //name of the test for report
        extentLogger = report.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        extentLogger.info("Enter username: wronguser");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        extentLogger.info("Enter Password: UserUser123");
        loginPage.loginBtn.click();
        extentLogger.info("Click login button");
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        //we put after assertion so if the assertion fails, it will not send pass to report
        extentLogger.pass("PASS:Wrong Password Test");
    }
}