package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int Wait_Time = 10;
	
	public static String generateEmailId() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ","_").replace(":","_");
		return "amitpirannavar"+timeStamp+"@gmail.com";
	}
	public static String takingScreenshot(WebDriver driver ,String testName) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotDestination = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot,new File(ScreenshotDestination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ScreenshotDestination;
		
	}

}
