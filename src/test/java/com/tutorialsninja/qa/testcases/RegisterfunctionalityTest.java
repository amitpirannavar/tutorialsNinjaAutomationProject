package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountSuccessPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.RegisterPage;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utilities.Utilities;

public class RegisterfunctionalityTest extends Base{
	
	HomePage hm ;
	RegisterPage rg;
	AccountSuccessPage ap;
	public WebDriver driver;
	Logger log;
	public RegisterfunctionalityTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		log = LogManager.getLogger(RegisterfunctionalityTest.class.getName());
	    driver = InitilizationOfBrowser();
	    log.debug("Browser got Launched"); 
		hm = new HomePage(driver);
		rg = new RegisterPage(driver);
		hm.ClickOnMyAccountOption();
		log.debug("Clicked on MyAccount Option"); 
		rg.ClickOnRegister();
		log.debug("Clicked on Register Option"); 
	}
    @Test(priority = 0)
	public void VerifyRegisteringWithOnlyMandatoryFields() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	 log.debug("Entered FirstName");
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	 log.debug("Entered LastName"); 
    	rg.enterEmail(Utilities.generateEmailId());
    	 log.debug("Entered Email"); 
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	 log.debug("Entered Telephone Number"); 
    	rg.enterPassword(dataprop.getProperty("Password"));
    	 log.debug("Entered Password"); 
    	rg.enterConfirPassword(dataprop.getProperty("Password"));
    	log.info("Checked Confirm Password");
    	rg.ClickOnAgreecheckBox();
    	 log.debug("Clicked on Agree CheckBox"); 
    	rg.ClickSubmitButton();
    	 log.debug("Clicked On sumbit Button");
    	ap = new AccountSuccessPage(driver);
    	Assert.assertEquals(ap.retriveAccountSuccessFullMessage(),dataprop.getProperty("AccountSuccesfulMessage"),"Account has not created");
    	log.info("Account Successfull Message Displayed");
    }
    @Test(priority =1)
    public void VerifyRegisteringAccountwhenYESoptionselectedOnNewsletterfield() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	 log.debug("Entered FirstName");
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	 log.debug("Entered LastName"); 
    	rg.enterEmail(Utilities.generateEmailId());
    	log.debug("Entered Email"); 
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	log.debug("Entered Telephone Number"); 
    	rg.enterPassword(dataprop.getProperty("Password"));
    	 log.debug("Entered Password"); 
    	rg.enterConfirPassword(dataprop.getProperty("Password"));
    	log.info("Checked Confirm Password");
    	rg.ClickYesOnRadioButton();
    	log.debug("Clicked on RadionButton");
    	rg.ClickOnAgreecheckBox();
    	 log.debug("Clicked on Agree CheckBox"); 
    	rg.ClickSubmitButton();
    	log.debug("Clicked On sumbit Button");
    	ap = new AccountSuccessPage(driver);
    	Assert.assertEquals(ap.retriveAccountSuccessFullMessage(),dataprop.getProperty("AccountSuccesfulMessage"),"Account has not created");
    	log.info("Account Successfull Message Displayed");
    }
    @Test(priority = 2)
    public void VerifyRegisteringAccountwhenNOoptionselectedOnNewsletterfield() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	 log.debug("Entered FirstName");
    	rg.enterLastName(dataprop.getProperty("LastName"));
      	 log.debug("Entered LastName"); 
    	rg.enterEmail(Utilities.generateEmailId());
    	log.debug("Entered Email");
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	log.debug("Entered Telephone Number");
    	rg.enterPassword(dataprop.getProperty("Password"));
    	 log.debug("Entered Password");
    	rg.enterConfirPassword(dataprop.getProperty("Password"));
    	log.info("Checked Confirm Password");
    	rg.ClickNoOnRadioButton();
    	log.debug("Clicked on RadionButton");
    	rg.ClickOnAgreecheckBox();
    	 log.debug("Clicked on Agree CheckBox"); 
    	rg.ClickSubmitButton();
    	log.debug("Clicked On sumbit Button");
    	ap = new AccountSuccessPage(driver);
    	Assert.assertEquals(ap.retriveAccountSuccessFullMessage(),dataprop.getProperty("AccountSuccesfulMessage"),"Account has not created");
    	log.info("Account Successfull Message Displayed");	
    }
    @Test(priority = 3)
    public void VerifyRegisteringAccountEnteringdifferentpasswordsintoPasswordandPasswordConfirmfields() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	log.debug("Entered FirstName");
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	log.debug("Entered LastName"); 
    	rg.enterEmail(Utilities.generateEmailId());
    	log.debug("Entered Email");
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	log.debug("Entered Telephone Number");
    	rg.enterPassword(dataprop.getProperty("Password"));
    	 log.debug("Entered Password");
    	rg.enterConfirPassword(dataprop.getProperty("InValidPassword"));
    	driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("InValidPassword"));
    	log.info("Checked Confirm Password");
    	rg.ClickNoOnRadioButton();
    	log.debug("Clicked on RadionButton");
    	rg.ClickOnAgreecheckBox();
    	 log.debug("Clicked on Agree CheckBox"); 
    	rg.ClickSubmitButton();
    	log.debug("Clicked On sumbit Button");
    	Assert.assertEquals(rg.retrivePasswordWarningMessage(),dataprop.getProperty("PasswordWarningMessage"),"Account has not created"); 	
    	log.info("PassWord warning Message Displayed");
    }   
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    	log.debug("Browser got Closed");
    }
	
    
	
	
}
