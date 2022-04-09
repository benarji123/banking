package com.banking.TestCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.banking.Utilities.PropertiesFileConfig;
import com.banking.pageObject.DepositePageObj;
import com.banking.pageObject.LoginPage;

public class TC_Diposite_006 extends Baseclass {
	@Test
	public void deposit() throws Throwable {
      test=extent.createTest("deposite");
	
		LoginPage o=new LoginPage(driver);
		o.setUserName(PropertiesFileConfig.getKey("username"));
	
		o.setPassword(PropertiesFileConfig.getKey("password"));
	
		o.clickLoginButton();
    DepositePageObj dp=new DepositePageObj(driver);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    dp.Deposit.click();
    FileReader r=new FileReader("./Capturedata/Accountnum.txt");
	BufferedReader bf=new BufferedReader(r);
	String accountnum=bf.readLine();
    dp.accountnumber.sendKeys(accountnum);
    dp.Amount.sendKeys("500");
    dp.Description.sendKeys("this is my first deposite");
    dp.submit.click();
    if(driver.getPageSource().contains("Transaction details of Deposit for Account")) {
    	Assert.assertTrue(true);
    }else {
      	Assert.assertTrue(false);
    }
		
	}
	
	

}
