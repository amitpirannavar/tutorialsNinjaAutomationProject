package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage {
	public WebDriver driver;
	
	public searchPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath = "//div[@id='content']/h2//following-sibling::p")
	private WebElement invalidProduct;
	
	
	//Action
	public String noProductFound() {
		String noProduct =invalidProduct.getText();
		return noProduct;
		
	}
	public boolean displayStatusOfValidProduct() {
		
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
		
	}

}
