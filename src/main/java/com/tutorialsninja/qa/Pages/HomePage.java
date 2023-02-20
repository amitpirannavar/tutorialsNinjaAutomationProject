package com.tutorialsninja.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
<<<<<<< HEAD
	@FindBy(xpath ="//a[@title = 'My Account']")
=======
	@FindBy(xpath = "//a[@title = 'My Account']")
>>>>>>> 4b2d03c6f8abe9177dd4326bed53543da8a820ad
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
		// WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(2));
        // wait.until(ExpectedConditions.elementToBeClickable(AccountDropMenu));
         AccountDropMenu.click();
		
	}
	public void ClickOnLoginOption() {
		
		LoginOption.click();
	}
	
	
	
	
}
