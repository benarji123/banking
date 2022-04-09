package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DepositePageObj {
	 WebDriver ldriver;
	public DepositePageObj(WebDriver rdriver ) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@CacheLookup
	@FindBy(xpath="/html/body/div[3]/div/ul/li[8]/a")
	public WebElement Deposit;
	@CacheLookup
	@FindBy(name="accountno")
	public WebElement accountnumber;
	@CacheLookup
	@FindBy(name="ammount")
	public WebElement Amount;
	@CacheLookup
	@FindBy(name="desc")
	public WebElement Description;
	@CacheLookup
	@FindBy(name="AccSubmit")
	public WebElement submit;

}
