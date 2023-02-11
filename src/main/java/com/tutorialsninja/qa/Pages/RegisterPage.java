package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement register;
	
	@FindBy(id="input-firstname")
	private WebElement nameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastnameField;
	
	@FindBy(id = "input-email")
	private WebElement emailFiled;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordFiled;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreeCheckBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//label[@class='radio-inline'][1]")
	private WebElement radiobuttonYes;
    
	@FindBy(xpath = "//label[@class='radio-inline'][2]")
	private WebElement radiobuttonNO;
	
	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement PasswordWorngMessage;
	//Actions
	
	public void ClickOnRegister() {
		register.click();
	}
	public void enterFirstName(String FirstName) {
		nameField.sendKeys(FirstName);
	}
	public void enterLastName(String PasswordText) {
		lastnameField.sendKeys(PasswordText);
	}
	public void enterEmail(String EmailText) {
		emailFiled.sendKeys(EmailText);
	}
	public void enterTelephoneNumber(String TelephoneNumber) {
		telephoneField.sendKeys(TelephoneNumber);
	}
	public void enterPassword(String Password) {
		passwordFiled.sendKeys(Password);
	}
	public void enterConfirPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	public void ClickOnAgreecheckBox() {
		agreeCheckBox.click();
	}
	public void ClickSubmitButton() {
		submitButton.click();
	}
	public void ClickYesOnRadioButton() {
		radiobuttonYes.click();
	}
	public void ClickNoOnRadioButton(){
		radiobuttonNO.click();
	}
	public String retrivePasswordWarningMessage() {
		String PasswordWrongMessage = PasswordWorngMessage.getText();
		return PasswordWrongMessage;
	}	
}
