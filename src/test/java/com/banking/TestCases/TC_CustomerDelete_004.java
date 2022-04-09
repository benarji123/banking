package com.banking.TestCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.Utilities.PropertiesFileConfig;
import com.banking.pageObject.DeleteCustomer;
import com.banking.pageObject.LoginPage;

public class TC_CustomerDelete_004 extends Baseclass {
     @Test
	public void customerDelete() throws Throwable {
    	 test=extent.createTest("customerdelete");
		
		LoginPage o=new LoginPage(driver);
		o.setUserName(PropertiesFileConfig.getKey("username"));
	
		o.setPassword(PropertiesFileConfig.getKey("password"));
	
		o.clickLoginButton();
		DeleteCustomer d=new DeleteCustomer(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		d.CustomerDeleteLink.click();
		FileReader r=new FileReader("./Capturedata/customerid.txt");
		BufferedReader bf=new BufferedReader(r);
		String customerid=bf.readLine();
		d.Customeid.sendKeys(customerid);
		d.SubmitButton.click();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			
		}
		
	
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	
}
