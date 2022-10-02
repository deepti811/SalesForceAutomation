
package com.firebasse.test.pages.login;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebasse.test.pages.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement loginButton;
	@FindBy(xpath="//div[@id='error']")WebElement errorMessage;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement remember;
	@FindBy(id="forgot_password_link") WebElement forgetpassword;
	
	public  void clickonForgetPassword()
	{
		clickElement(forgetpassword,"click on remember me");
		
	}
	public void userNameIsDisplayed()
	{
		if (username.isDisplayed()) {
			
			report.logTestInfo("pass:" +  "  element cleared");

		} else {
			report.logTestFailed("fail:" + "  element cleared");
		}
	}
	public String GetTextFromLoginPageElement() {
		String text=readText(errorMessage, "text form field");
		String path=captureWebElementScreenshot(errorMessage,"error message image");
		try {
		report.attachScreenshot(path);
		} catch (Exception  e) {
			report.logTestFailedWithExcetion(e);
		}
		return text;
	}
	public  void clickonRemeberMe(){
		clickElement(remember,"click on remember me");	
	}
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void enterUserName(String usrname) {
		waitUntilVisible(username,"user name field");
		enterText(username, usrname, "username field");
	}
	public void enterPassword(String passWord) {
		enterText(password, passWord, "password field");	
	}
	public void clickLoginButton() {
		System.out.println("Click loging element*********");
		clickElement(loginButton,"login button");
	}
	public void login(String usrname,String passWrd) {
		enterUserName(usrname);
		enterPassword(passWrd);
		clickLoginButton();
	}
	
	

}
