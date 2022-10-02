package com.firebase.test.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.firebase.test.base.BaseTest;
import com.firebase.test.utility.CommonUtilities;
import com.firebasse.test.pages.forgetpassword.CheckEmailPage;
import com.firebasse.test.pages.forgetpassword.ForgetpasswordPage;
import com.firebasse.test.pages.home.HomePage;
import com.firebasse.test.pages.login.LoginPage;


public class AutomationScripts extends BaseTest {	
	@Test
	public static void TestID_1LoginErrorMessage() throws Exception {
		String expected="Please enter your password.";
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String usrname = CU.getApplicationProperty("username", applicationPropertiesFile);
		LoginPage login=new LoginPage(driver);
		login.login(usrname, "");
		String actual=login.GetTextFromLoginPageElement();
		if(!expected.equals(actual))
		report.logTestFailed("assertion failed");
		Assert.assertEquals(actual, expected);
		report.logTestInfo("TestScript exection is completed");
	}
	@Test
	public static void TestID_2LoginToSalesForce() throws Exception {
	String expected = "Home Page ~ Salesforce - Developer Edition";
	CommonUtilities CU = new CommonUtilities();
	Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
	String usrname = CU.getApplicationProperty("username", applicationPropertiesFile);
	String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
	LoginPage login=new LoginPage(driver);
	login.login(usrname, passwrd);
	HomePage homepage=new HomePage(driver);
	String actual=homepage.getPageTitle();
	if(!expected.equals(actual))
		report.logTestFailed("assertion failed");
		Assert.assertEquals(actual, expected);
		report.logTestInfo("TestScript exection is completed");
}
@Test
public static void TestID_3CheckRemeberMe()  throws Exception{
	logger.info("Login");
	LoginPage login=new LoginPage(driver);
	CommonUtilities CU = new CommonUtilities();
	Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
	String usrname = CU.getApplicationProperty("username", applicationPropertiesFile);
	String passwrd = CU.getApplicationProperty("password", applicationPropertiesFile);
	login.enterUserName(usrname);
	login.enterPassword(passwrd);
	login.clickLoginButton();
	login.clickonRemeberMe();
	logger.info("login$$$$$");
	HomePage homepage=new HomePage(driver);
	logger.info("homepage");
	
	homepage.clickOnUserMenuDropDown();
	logger.info("clickOnUserMenuDropDown");
	Thread.sleep(3000);
	homepage.clickOnLogout();
	
	logger.info("clickOnLogout");
	login.userNameIsDisplayed();
	logger.info("userNameIsDisplayed");
	
}
@Test
public static void TestID_4AForgotPassword() throws Exception {
	LoginPage login=new LoginPage(driver);
	login.clickonForgetPassword();
	CommonUtilities CU = new CommonUtilities();
	Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
	String usrname = CU.getApplicationProperty("username", applicationPropertiesFile);
	ForgetpasswordPage forget=new ForgetpasswordPage(driver);
	forget.continue1(usrname);
	String expected="Check Your Email";
	CheckEmailPage check=new CheckEmailPage(driver);
	String actual=check.GetTextFromCheckEmail();
	logger.info(actual);
	Assert.assertEquals(actual, expected);
	report.logTestInfo("Password reset message page is displayed. "
			+ "An email associated with the <username> account is sent.");
}
@Test
public static void TestID_4BForgotPassword() throws Exception {
	CommonUtilities CU = new CommonUtilities();
	Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
	String wrongusrname = CU.getApplicationProperty("wrongusername", applicationPropertiesFile);
	String wrongpasswrd = CU.getApplicationProperty("wrongpassword", applicationPropertiesFile);
	LoginPage login=new LoginPage(driver);
	login.login(wrongusrname, wrongpasswrd);
	String expected="Please check your username and password."
			+ " If you still can't log in, contact your Salesforce administrator.";
	String actual=login.GetTextFromLoginPageElement();
	Assert.assertEquals(actual, expected);
	report.logTestInfo("\"Error message should be displayed\n"
			+ "'Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. "
			+ "Please contact the administrator at your company for help'\"");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}