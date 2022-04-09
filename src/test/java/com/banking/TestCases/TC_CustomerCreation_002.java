package com.banking.TestCases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.banking.Utilities.PropertiesFileConfig;
import com.banking.pageObject.LoginPage;
import com.banking.pageObject.NewCustomerCreation;



public class TC_CustomerCreation_002 extends Baseclass {
	  @ Test
	  public void customerCreation() throws Throwable  {
		  test=extent.createTest("cusomercreation");
			LoginPage o=new LoginPage(driver);
			o.setUserName(PropertiesFileConfig.getKey("username"));
			test.log(Status.INFO, "Ented username");
		
			o.setPassword(PropertiesFileConfig.getKey("password"));
			test.log(Status.INFO, "Ented Password");
		
			o.clickLoginButton();
			test.log(Status.INFO, "clicked");
			Thread.sleep(4000);
		  NewCustomerCreation c= new NewCustomerCreation(driver);
		  c.NewCustomerLink.click();
		  c.CustomerName.sendKeys("alekya");
		  c.RadioButton.click();
		  c.date("03","05","1994");
		  Thread.sleep(300);
		  c.Address.sendKeys("odisha");
		  c.City.sendKeys("ganjam");
		  c.State.sendKeys("odisha");
		  c.PIN.sendKeys("123345");
		  c.MobileNumber.sendKeys("9848315169");
		String mail=  StringEmail()+"@gmail.com";
		  c.Email.sendKeys(mail);
		  c.Password.sendKeys("alekhf123");
		  c.SubmitBtton.click();
		  Thread.sleep(4000);
		  if(driver.getPageSource().contains("benarji")) {
			  Assert.assertTrue(true);
			  FileWriter w= new FileWriter("./Capturedata/customerid.txt");
			  BufferedWriter bw=new BufferedWriter(w);
			 String customeid= driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
			 bw.write(customeid);
			 bw.flush();
			  
			  
		  }else {
			  Assert.assertTrue(false);
		  }
		
		  
	  }
	 
	  
	
	
	

}
