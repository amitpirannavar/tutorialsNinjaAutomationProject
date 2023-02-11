package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.time.Duration;

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
	public LoginFunctionalityTest() {
		super();
	}
//	public WebDriver driver;
	
	@BeforeMethod
	public void openApplication(){
		driver = InitilizationOfBrowser();
		hm = new HomePage(driver);
		hm.ClickOnMyAccountOption();
		hm.ClickOnLoginOption();
		
	}
	@Test(priority = 0)
	public void VerifyLoginWithValidCreadentials() throws InterruptedException{
		lg = new LoginPage(driver);
		lg.enterEmailAddress(prop.getProperty("ValidEmail"));
		lg.enterPassword(prop.getProperty("ValidPassword"));
		lg.ClickOnLoginButton();
		Thread.sleep(10000);
		Assert.assertTrue(lg.retrivingMessageOfEdityourOption().contains(dataprop.getProperty("EditYourOptionDisplay")),"Edit your account option is not displayed");
	}
	

	@Test(priority = 1)
	public void verifyLoginWithInValidCreadentials() {
		lg = new LoginPage(driver);
		lg.enterEmailAddress(Utilities.generateEmailId());
		lg.enterPassword(dataprop.getProperty("InValidPassword"));
		lg.ClickOnLoginButton();
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
	}
	@Test(priority = 2)
	public void VerifyLoggingWithInValidEmailAndValidPassword() {
		lg = new LoginPage(driver);
		lg.enterEmailAddress(Utilities.generateEmailId());
		lg.enterPassword(prop.getProperty("ValidPassword"));
		lg.ClickOnLoginButton();
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
	}
	@Test(priority = 3)
	public void VerifyLoggingWithValidEmailAndInvalidPassword() {
		lg = new LoginPage(driver);
		lg.enterEmailAddress(prop.getProperty("ValidEmail"));
		lg.enterPassword(dataprop.getProperty("InValidPassword"));
		lg.ClickOnLoginButton();
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");

	}
	@Test(priority = 4)
	public void VerifyLoggingWithoutCreadentials() {
		lg = new LoginPage(driver);
		lg.ClickOnLoginButton();
		Assert.assertEquals(lg.retriveMessageForEmailAndPasswordNotmaching(),dataprop.getProperty("EmailAndPasswordNotMatchWarning"),"Expected Warning Message is not Displayed");
	}
	@Test(priority = 5)
	public void VerifyForgetpasswordlinkisWorking() {
		fg = new forgetPasswordPage(driver);
		lg  = new LoginPage(driver);
		lg.ClickOnforgetpasswordlink();
	    Assert.assertEquals(fg.retriveforgetPasswordMessage(),dataprop.getProperty("forgetpasswordMessage"),"Expected Results no Displayed");	
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
