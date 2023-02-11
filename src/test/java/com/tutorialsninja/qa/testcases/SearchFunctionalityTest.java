package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.Pages.searchPage;
import com.tutorialsninja.qa.base.Base;

public class SearchFunctionalityTest extends Base {
	public WebDriver driver;
	HomePage hm;
	LoginPage pg;
	searchPage sc;
	
	public SearchFunctionalityTest() {
		super();
	}
	
	@BeforeMethod()
	public void SetUp() throws InterruptedException{
		driver = InitilizationOfBrowser();
		hm = new HomePage(driver);
		hm.ClickOnMyAccountOption();
		hm.ClickOnLoginOption();
		pg = new LoginPage(driver);
		pg.enterEmailAddress(prop.getProperty("ValidEmail"));
		pg.enterPassword(prop.getProperty("ValidPassword"));
		pg.ClickOnLoginButton();
		Thread.sleep(5000);
	}
	
	@Test(priority =0)
	public void VerifySearchingValidProduct() {
		hm = new HomePage(driver);
		hm.searchingProduct(dataprop.getProperty("ValidProduct"));
		hm.clickOnSearchButton();
		sc = new searchPage(driver);
		Assert.assertTrue(sc.displayStatusOfValidProduct(),"Valid product HP is not displayed in the Search results");
	}
	@Test(priority =1)
	public void VerifySearchingWithInvalidProduct() {
		hm = new HomePage(driver);
		hm.searchingProduct(dataprop.getProperty("InvalidProduct"));
		hm.clickOnSearchButton();
		sc = new searchPage(driver);
		Assert.assertEquals(sc.noProductFound(),dataprop.getProperty("NoProductFoundMessage"),"No Product Found Message is not Displyed");
		
	}
	@Test(priority =2)
	public void VerifyWithOutProvidingProductInSearchFiled() {
		hm = new HomePage(driver);
		hm.clickOnSearchButton();
		sc = new searchPage(driver);
		Assert.assertEquals(sc.noProductFound(),dataprop.getProperty("NoProductFoundMessage"),"No Product Found Message is not Displyed");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
