package com.tutorialsninja.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tutorialsninja.qa.utilities.Utilities;

public class Base {
	
	WebDriver driver ;
	public Properties prop ,dataprop;

	
	public Base() {
	    dataprop = new Properties();
		String datapath  = System.getProperty("user.dir")+"\\src\\main\\java\\com\\tuturialsninja\\qa\\testdata\\testdata.properties";
		try {
				FileInputStream fis2 = new FileInputStream(datapath);
	
			dataprop.load(fis2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 prop = new Properties();
			String proppath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Data.properties";
			try {
				FileInputStream fis = new FileInputStream(proppath);
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	public WebDriver InitilizationOfBrowser() {
		String browserName = prop.getProperty("browserName");
		 
		 if(browserName.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();			 
		 }
		 else if(browserName.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}
		 else if(browserName.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Wait_Time));
		 driver.get(prop.getProperty("url"));
		 
		 return driver;
	}
	
	
}
