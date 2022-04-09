package com.banking.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.banking.Utilities.PropertiesFileConfig;
import com.banking.pageObject.LoginPage;




public class TC_Login_001 extends Baseclass {
	@Test
	public void loginTest() throws Throwable {
		//driver.get(PropertiesFileConfig.getKey("baseURL"));
		test=extent.createTest("login");
	
		LoginPage o=new LoginPage(driver);
		o.setUserName(PropertiesFileConfig.getKey("username"));
	
		o.setPassword(PropertiesFileConfig.getKey("password"));
	
		o.clickLoginButton();
	
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		
		}
		else {
			Assert.assertFalse(true);
		
		}
	
		

			
		
	}

	

}
