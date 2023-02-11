package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.time.Duration;

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
	public RegisterfunctionalityTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
	    driver = InitilizationOfBrowser();
		hm = new HomePage(driver);
		rg = new RegisterPage(driver);
		hm.ClickOnMyAccountOption();
		rg.ClickOnRegister();
	}
    @Test(priority = 0)
	public void VerifyRegisteringWithOnlyMandatoryFields() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	rg.enterEmail(Utilities.generateEmailId());
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	rg.enterPassword(dataprop.getProperty("Password"));
    	rg.enterConfirPassword(dataprop.getProperty("Password"));
    	rg.ClickOnAgreecheckBox();
    	rg.ClickSubmitButton();
    	ap = new AccountSuccessPage(driver);
    	Assert.assertEquals(ap.retriveAccountSuccessFullMessage(),dataprop.getProperty("AccountSuccesfulMessage"),"Account has not created");
    }
    @Test(priority =1)
    public void VerifyRegisteringAccountwhenYESoptionselectedOnNewsletterfield() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	rg.enterEmail(Utilities.generateEmailId());
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	rg.enterPassword(dataprop.getProperty("Password"));
    	rg.enterConfirPassword(dataprop.getProperty("Password"));
    	rg.ClickYesOnRadioButton();
    	rg.ClickOnAgreecheckBox();
    	rg.ClickSubmitButton();
    	ap = new AccountSuccessPage(driver);
    	Assert.assertEquals(ap.retriveAccountSuccessFullMessage(),dataprop.getProperty("AccountSuccesfulMessage"),"Account has not created");
    }
    @Test(priority = 2)
    public void VerifyRegisteringAccountwhenNOoptionselectedOnNewsletterfield() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	rg.enterEmail(Utilities.generateEmailId());
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	rg.enterPassword(dataprop.getProperty("Password"));
    	rg.enterConfirPassword(dataprop.getProperty("Password"));
    	rg.ClickNoOnRadioButton();
    	rg.ClickOnAgreecheckBox();
    	rg.ClickSubmitButton();
    	ap = new AccountSuccessPage(driver);
    	Assert.assertEquals(ap.retriveAccountSuccessFullMessage(),dataprop.getProperty("AccountSuccesfulMessage"),"Account has not created");
    	
    }
    @Test(priority = 3)
    public void VerifyRegisteringAccountEnteringdifferentpasswordsintoPasswordandPasswordConfirmfields() {
    	rg = new RegisterPage(driver);
    	rg.enterFirstName(dataprop.getProperty("FirstName"));
    	rg.enterLastName(dataprop.getProperty("LastName"));
    	rg.enterEmail(Utilities.generateEmailId());
    	rg.enterTelephoneNumber(dataprop.getProperty("Telephone"));
    	rg.enterPassword(dataprop.getProperty("Password"));
    	rg.enterConfirPassword(dataprop.getProperty("InValidPassword"));
    	driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("InValidPassword"));
    	rg.ClickNoOnRadioButton();
    	rg.ClickOnAgreecheckBox();
    	rg.ClickSubmitButton();
    	Assert.assertEquals(rg.retrivePasswordWarningMessage(),dataprop.getProperty("PasswordWarningMessage"),"Account has not created"); 	
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
	
    
	
	
}
