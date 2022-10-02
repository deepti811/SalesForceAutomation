package com.firebasse.test.pages.forgetpassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebasse.test.pages.base.BasePage;

public class CheckEmailPage extends BasePage {
	public CheckEmailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[@id='header']")WebElement errorMessage;

	public String GetTextFromCheckEmail() {
	String text=readText(errorMessage, "text form field");
	return text;
}
}