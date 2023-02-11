package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.ExtentReport;
import com.tutorialsninja.qa.utilities.Utilities;

public class MyListeners implements ITestListener{
	
	ExtentReports extentreports;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		 extentreports = ExtentReport.generateReport();
}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentreports.createTest(testName);
		extentTest.log(Status.INFO,testName+"Start Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName =result.getName();
		extentTest.log(Status.PASS,"got Executed Succesfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		
		WebDriver driver =null ;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		String ScreenshotDestination =Utilities.takingScreenshot(driver, testName);
		
		extentTest.addScreenCaptureFromPath(ScreenshotDestination);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,testName+"Test got Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP,testName+"Test got Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
		String pathofReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreports.html";
		File extentReport = new File(pathofReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
