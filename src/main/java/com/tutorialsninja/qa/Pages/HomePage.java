package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@title = 'My Account']")
	private WebElement AccountDropMenu;
	
	
	@FindBy(xpath = "//li/a[text()='Login']")
	private WebElement LoginOption;
	
	@FindBy(name = "search")
	private WebElement searchBar;
	
	@FindBy(xpath = "//div[@id='search']//descendant::button")
	private WebElement SearchButton;
	
	//Actions
	public void searchingProduct(String validProduct) {
		searchBar.sendKeys(validProduct);
	}
	public void clickOnSearchButton() {
		SearchButton.click();
	}
	public void ClickOnMyAccountOption() {
		
		AccountDropMenu.click();
		
	}
	public void ClickOnLoginOption() {
		
		LoginOption.click();
	}
	
	
	
	
}
