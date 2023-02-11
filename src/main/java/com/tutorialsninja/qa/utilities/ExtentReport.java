package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	
	public static ExtentReports generateReport() {
		
		ExtentReports extentreport = new ExtentReports();
		File extentreportpath = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreports.html");
		ExtentSparkReporter sparkReport= new ExtentSparkReporter(extentreportpath);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("Automation Test For TN");
		sparkReport.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		sparkReport.config().setReportName("TutorialsNinja Automation Test Report");
		
		Properties configprop = new Properties();
		File fisconfigFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Data.properties");
		try {
		FileInputStream fisconfig = new FileInputStream(fisconfigFile);
		configprop.load(fisconfig);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		extentreport.attachReporter(sparkReport);
		extentreport.setSystemInfo("Application URL",configprop.getProperty("url"));
		extentreport.setSystemInfo("Browser Name",configprop.getProperty("browserName"));
		extentreport.setSystemInfo("Email",configprop.getProperty("ValidEmail"));
		extentreport.setSystemInfo("Password",configprop.getProperty("ValidPassword"));
		extentreport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentreport.setSystemInfo("User Name ",System.getProperty("user.name"));
		extentreport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentreport;





		

	}

}
