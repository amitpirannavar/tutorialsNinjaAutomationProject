package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgetPasswordPage {
	public WebDriver driver ;
	
	public forgetPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
    @FindBy(xpath = "//div[@id='content']/h1")
	private WebElement forgetPasswordMessage;
    
    
    
    public String retriveforgetPasswordMessage() {
    	String forgetPasswordMessageDisplay = forgetPasswordMessage.getText();
    	return forgetPasswordMessageDisplay;
    }
    
	

}
