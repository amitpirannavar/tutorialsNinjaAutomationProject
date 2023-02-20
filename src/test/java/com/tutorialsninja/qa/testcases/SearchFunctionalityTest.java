package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	Logger log;
	
	public SearchFunctionalityTest() {
		super();
	}
	
	@BeforeMethod()
	public void SetUp() throws InterruptedException{
		log = LogManager.getLogger(SearchFunctionalityTest.class.getName());
		driver = InitilizationOfBrowser();
		log.debug("Browser got launched");
		hm = new HomePage(driver);
		hm.ClickOnMyAccountOption();
		log.debug("Clicked on My Account option");
		hm.ClickOnLoginOption();
		log.debug("Clicked on Login Option");
		pg = new LoginPage(driver);
		pg.enterEmailAddress(prop.getProperty("ValidEmail"));
		log.debug("Entered Email");
		pg.enterPassword(prop.getProperty("ValidPassword"));
		log.debug("Entered Password");
		pg.ClickOnLoginButton();
		log.debug("Clicked on Login Button");
		Thread.sleep(5000); 
	}
	
	@Test(priority =0)
	public void VerifySearchingValidProduct() {
		hm = new HomePage(driver);
		hm.searchingProduct(dataprop.getProperty("ValidProduct"));
		log.debug("Entered Product");
		hm.clickOnSearchButton();
		log.debug("Clicked On Search Button");
		sc = new searchPage(driver);
		Assert.assertTrue(sc.displayStatusOfValidProduct(),"Valid product HP is not displayed in the Search results");
		log.info("Valid Product got displayed");
	}
	@Test(priority =1)
	public void VerifySearchingWithInvalidProduct() {
		hm = new HomePage(driver);
		hm.searchingProduct(dataprop.getProperty("InvalidProduct"));
		log.debug("Enetered Product");
		hm.clickOnSearchButton();
		log.debug("Clicked On Search Button");
		sc = new searchPage(driver);
		Assert.assertEquals(sc.noProductFound(),dataprop.getProperty("NoProductFoundMessage"),"No Product Found Message is not Displyed");
		log.info("No Product Message got displayed");
	}
	@Test(priority =2)
	public void VerifyWithOutProvidingProductInSearchFiled() {
		hm = new HomePage(driver);
		hm.clickOnSearchButton();
		log.debug("Clicked On Search Button");
		sc = new searchPage(driver);
		Assert.assertEquals(sc.noProductFound(),dataprop.getProperty("NoProductFoundMessage"),"No Product Found Message is not Displyed");
		log.info("No Product Message got displayed");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.debug("Browser got Closed");
	}

}
