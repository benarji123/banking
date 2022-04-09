package com.banking.TestCases;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.banking.Utilities.PropertiesFileConfig;

public class Baseclass {
	    public WebDriver driver ;
		public ExtentSparkReporter htmlrepo;
		public ExtentReports extent;
		public ExtentTest test ;

	//public  WebDriver driver;
	
	public Logger logger= LogManager.getLogger(Baseclass.class);
	@BeforeTest
	public  void setExtent() {
		htmlrepo=new ExtentSparkReporter(System.getProperty("user.dir")+"/Extentsreport/"+getdate()+".html");
		htmlrepo.config().setDocumentTitle("Automation Report");//title of the report
		htmlrepo.config().setReportName("Functional Report");//name of the report
		htmlrepo.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlrepo);
		extent.setSystemInfo("Hostname","LocalHost");
		extent.setSystemInfo("Os","windows7");
		extent.setSystemInfo("Browser","Chrome");
		
	}
	
	@BeforeMethod
	public void setUp( ) throws Throwable {
		if(PropertiesFileConfig.getKey("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		} else if(PropertiesFileConfig.getKey("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		driver.get("http://demo.guru99.com/V4/index.php");
    	
  
	}
	
	@AfterMethod
	public void rearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS "+ result.getName());//to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS "+ result.getThrowable());// to add error /exception
			String screenshotpath=Baseclass.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotpath); //add screenshots			
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS" + result.getName());
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE SUCCESSED IS" + result.getName());
		}
		
		driver.quit();
		
		
	}
	@AfterTest
	public void endRoport() {
		extent.flush();
		
	}
    
   
	 public String StringEmail() {
			String randomid=  RandomStringUtils.randomAlphabetic(8);
			return randomid;
			  
			  
			  
		  }
	 public  String randomNumber() {
			String num=  RandomStringUtils.randomNumeric(6);
			return num;
		  }
		
			
			
			

			
	public static String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
				String dateName=new SimpleDateFormat("yyyyMMdd hhmmss").format(new Date());
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String destination=System.getProperty("user.dir")+"/ScreenShots/"+ScreenshotName + dateName + ".png";
				File finaldestination = new File(destination);
				FileUtils.copyFile(source, finaldestination);
				return destination;
				
				
				
			}
	public  String getdate() {
		String date=new SimpleDateFormat("YYYY-MM-dd hh-mm-ss").format(new Date());
		return date;
	}
			
			
			
			
			
		   


}

