package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
 @FindBy(name="uid")
 @CacheLookup
 WebElement txtusername;
 
 @FindBy(name="password")
 @CacheLookup
 WebElement txtpassword;
 
 @FindBy(name="btnLogin")
 @CacheLookup
 WebElement loginbutton;
 
 public void setUserName(String username) {
	 txtusername.sendKeys(username);
}
 public void setPassword(String password) {
	 txtpassword.sendKeys(password);
 }
 public void clickLoginButton() {
	 loginbutton.click();
	 
 }
}