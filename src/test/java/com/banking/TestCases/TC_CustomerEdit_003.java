package com.banking.TestCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.Utilities.PropertiesFileConfig;
import com.banking.pageObject.CustomerEditPage;
import com.banking.pageObject.LoginPage;
import com.banking.pageObject.NewCustomerCreation;

public class TC_CustomerEdit_003 extends Baseclass {
	@Test
	public void customerEdit() throws Throwable {
		test=extent.createTest("customerEdit");
		LoginPage o=new LoginPage(driver);
		o.setUserName(PropertiesFileConfig.getKey("username"));
	
		o.setPassword(PropertiesFileConfig.getKey("password"));
	
		o.clickLoginButton();
		CustomerEditPage edit=new CustomerEditPage(driver);
		edit.EditCustomerlink.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		FileReader r=new FileReader("./Capturedata/customerid.txt");
		BufferedReader bf=new BufferedReader(r);
		String customerid=bf.readLine();
		edit.Customeid.sendKeys(customerid);
		edit.SubmitButton.click();
	
		NewCustomerCreation c= new NewCustomerCreation(driver);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		c.PIN.clear();
		String pin=randomNumber();
		c.PIN.sendKeys(pin);
		c.SubmitBtton.click();
		if(driver.getPageSource().contains("Customer details updated Successfully!!!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

		
		
	

}
