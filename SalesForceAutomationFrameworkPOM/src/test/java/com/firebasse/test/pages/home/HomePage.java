
package com.firebasse.test.pages.home;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebasse.test.pages.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath ="//span[@id='userNavLabel']") WebElement usermenu;
	@FindBy(xpath ="//a[@title='Logout']") WebElement logout;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	public void clickOnUserMenuDropDown() {
		clickElement(usermenu,"click on user menu drop down");
		waitUntilVisible(usermenu,"click on user menu drop down");
	}
	public void clickOnLogout() {
		clickElement(logout,"click on Logout");
		waitUntilVisible(logout,"click on Logout");
	}
	}
	
	

