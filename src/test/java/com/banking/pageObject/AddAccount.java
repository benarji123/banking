package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddAccount {

	WebDriver ldriver;
	public AddAccount(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		this.ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@CacheLookup
	@FindBy(xpath="/html/body/div[3]/div/ul/li[5]/a")
	public WebElement AddAccount;

	@CacheLookup
	@FindBy(name="cusid")
	public WebElement CustomerId;
	@CacheLookup
	@FindBy(name="selaccount")
	public WebElement AccountType;
	@CacheLookup
	@FindBy(name="inideposit")
	public WebElement DeposteAmount;
	@CacheLookup
	@FindBy(name="button2")
	public WebElement SubmitButton;
	
	public void selectAccountType(String text){
		Select s=new Select(AccountType);
		s.selectByValue(text);
		
	}
	
	
	
	
	
}
