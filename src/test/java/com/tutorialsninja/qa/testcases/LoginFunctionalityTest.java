package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.Pages.forgetPasswordPage;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utilities.Utilities;

public class LoginFunctionalityTest extends Base {
	LoginPage lg;
	HomePage hm;
	forgetPasswordPage fg;
	public WebDriver driver;
	Logger log;
	public LoginFunctionalityTest() {
		super();
	}
//	public WebDriver driver;
	
	@BeforeMethod
	public void openApplication(){
		log = LogManager.getLogger(LoginFunctionalityTest.class.getName());
		driver = InitilizationOfBrowser();
		log.debug("Browser got Launched");
		hm = new HomePage(driver);
		hm.ClickOnMyAccountOption();
		log.debug("Clicked on MyAccount option");
		hm.ClickOnLoginOption();
		log.debug("Clicked on Login Button");

		
	}
	@Test(priority = 0)
	public void VerifyLoginWithValidCreadentials() throws InterruptedException{
		lg = new LoginPage(driver);
		lg.enterEmailAddress(prop.getProperty("ValidEmail"));
		log.debug("Entered Email Address");

		lg.enterPassword(prop.getProperty("ValidPassword"));
		log.debug("Entered Password");

		lg.ClickOnLoginButton();
		log.debug("Clicked on Login Button to submit");

		Thread.sleep(10000);
		Assert.assertTrue(lg.retrivingMessageOfEdityourOption().contains(dataprop.getProperty("EditYourOptionDisplay")),"Edit your account option is not displayed");
		log.info("Account got Succesfully Loged In");
	}
	

	@Test(priority = 1)
	public void verifyLoginWithInValidCreadentials() {
		lg = new LoginPage(driver);
		lg.enterEmailAddress(Utilities.generateEmailId());
		log.debug("Entered Email Address");
		lg.enterPassword(dataprop.getProperty("InValidPassword"));
		log.debug("Entered Password");

		lg.ClickOnLoginButton();
		log.debug("Clicked on Login Button to submit");
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
		log.info("Warning message got Displayed");
	}
	@Test(priority = 2)
	public void VerifyLoggingWithInValidEmailAndValidPassword() {
		lg = new LoginPage(driver);
		lg.enterEmailAddress(Utilities.generateEmailId());
		log.debug("Entered Email Address");
		lg.enterPassword(prop.getProperty("ValidPassword"));
		log.debug("Entered Password");
		lg.ClickOnLoginButton();
		log.debug("Clicked on Login Button to submit");
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
		log.info("Warning message got Displayed");
	}
	
	@Test(priority = 3)
	public void VerifyLoggingWithValidEmailAndInvalidPassword() {
		lg = new LoginPage(driver);
		lg.enterEmailAddress(prop.getProperty("ValidEmail"));
		log.debug("Entered Email Address");
		lg.enterPassword(dataprop.getProperty("InValidPassword"));
		log.debug("Entered Password");
		lg.ClickOnLoginButton();
		log.debug("Clicked on Login Button to submit");
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
		log.info("Warning message got Displayed");
	}
	@Test(priority = 4)
	public void VerifyLoggingWithoutCreadentials() {
		lg = new LoginPage(driver);
		lg.ClickOnLoginButton();
		log.debug("Clicked on Login Button to submit");
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
		log.info("Warning message got Displayed");
	}
	@Test(priority = 5)
	public void VerifyForgetpasswordlinkisWorking() {
		fg = new forgetPasswordPage(driver);
		lg  = new LoginPage(driver);
		lg.ClickOnforgetpasswordlink();
		log.debug("Clicked on Forget Password link");
	    Assert.assertEquals(fg.retriveforgetPasswordMessage(),dataprop.getProperty("forgetpasswordMessage"),"Expected Results no Displayed");	
	    log.debug("Expected Results got Displayed");
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		log.debug("Driver got closed");
		
	}

}
