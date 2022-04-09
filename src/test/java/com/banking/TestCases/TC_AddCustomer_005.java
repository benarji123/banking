package com.banking.TestCases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.Utilities.PropertiesFileConfig;
import com.banking.pageObject.AddAccount;
import com.banking.pageObject.LoginPage;

public class TC_AddCustomer_005 extends Baseclass {
	@Test
	public void addAccount() throws Throwable {
		test=extent.createTest("Addcustomer");
		LoginPage o=new LoginPage(driver);
		o.setUserName(PropertiesFileConfig.getKey("username"));
	
		o.setPassword(PropertiesFileConfig.getKey("password"));
	
		o.clickLoginButton();
		AddAccount add=new AddAccount(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		add.AddAccount.click();
		FileReader r=new FileReader("./Capturedata/customerid.txt");
		BufferedReader bf=new BufferedReader(r);
		String customerid=bf.readLine();
		add.CustomerId.sendKeys(customerid);
		add.selectAccountType("Current");
		add.DeposteAmount.sendKeys("500");
		add.SubmitButton.click();
		if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
	       Assert.assertTrue(true);
	       FileWriter w= new FileWriter("./Capturedata/Accountnum.txt");
			  BufferedWriter bw=new BufferedWriter(w);
			 String customeid= driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
			 bw.write(customeid);
			 bw.flush();
		}else {
			Assert.assertTrue(false);
		}
		
	}

}
