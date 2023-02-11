package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordFiled;
	
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath ="//a[text()='Edit your account information']")
	private WebElement EditYourOption;
	
	@FindBy(xpath ="//div[text()=' Warning: No match for E-Mail Address and/or Password.']")
	private WebElement emailAndpasswordNotMatchingWarning;
	
	@FindBy(linkText = "Forgotten Password")
	private WebElement forgetPassword;
	
	
	
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
		
	}
	public void enterPassword(String passwordText) {
		passwordFiled.sendKeys(passwordText);
	}
	public void ClickOnLoginButton() {
		loginButton.click();
	}
	public String retrivingMessageOfEdityourOption() {
		String EditeMessage =EditYourOption.getText();
		return EditeMessage;
	}
	public String retriveMessageForEmailAndPasswordNotmaching() {
		String warningMessage = emailAndpasswordNotMatchingWarning.getText();
		return warningMessage;
	}
	public void ClickOnforgetpasswordlink() {
		forgetPassword.click();
		
	}
	
}
