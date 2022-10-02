package com.firebase.test.base;

import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.firebase.test.utility.CommonUtilities;
import com.firebase.test.utility.GenerateReports;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger logger =LogManager.getLogger(BaseTest.class);
	public static GenerateReports report=null;
	
	@BeforeTest
	public static void setupBeforetest() {
		report=GenerateReports.getInstance();
		report.startExtentReport();
	}
	@Parameters({ "browsername" })
	@BeforeMethod
	public static void setUp( String browsername, Method m) {
		logger.info("beofre method execution started");
		report.startSingleTestReport(m.getName());
		setDriver(browsername);
		CommonUtilities CU = new CommonUtilities();
		Properties applicationPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicationPropertiesFile);
		gotoUrl(url);
		waitUntilPageLoads();
	}
	
@AfterMethod
	public static void tearDown() {
		logger.info("after method execution is started");
		closeBrowser();
	}
	@AfterTest
	public static void teardownAfterTest()
	{
		report.endReport();
	}
	public static void setDriver(String browser) {

		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}
public static void gotoUrl(String url)	
{
	driver.get(url);
}
public static void waitUntilPageLoads() {
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
}
public static void closeBrowser()
{
	driver.close();
}
public static void closeAllBrowser()
{
	driver.quit();
}
		}

