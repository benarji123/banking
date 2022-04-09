package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerCreation {
	WebDriver ldriver;
	public NewCustomerCreation(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
    @CacheLookup
	@FindBy(xpath="//a[text()='New Customer']")
	
	 public WebElement NewCustomerLink;
    @CacheLookup
	@FindBy(name="name")
	public WebElement CustomerName;
    @CacheLookup
	@FindBy(xpath="//input[@value='f']")
	public  WebElement RadioButton;
    @CacheLookup
	@FindBy(xpath="//*[@id=\"dob\"]")
	public WebElement DOB;
    @CacheLookup
	@FindBy(name="addr")
	public WebElement Address;
    @CacheLookup
	@FindBy(name="city")
	public WebElement City;
    @CacheLookup
	@FindBy(name="state")
	public WebElement State;
    @CacheLookup
	@FindBy(name="pinno")
	public WebElement PIN;
    @CacheLookup
	@FindBy(name="telephoneno")
	public WebElement MobileNumber;
    @CacheLookup
	@FindBy(name="emailid")
	public WebElement Email;
    @CacheLookup
	@FindBy(name="password")
	public WebElement Password;
    @CacheLookup
	@FindBy(name="sub")
	public WebElement SubmitBtton;
    
    
    public void date(String day,String month,String year) {
    	
    	DOB.sendKeys(day);
    	DOB.sendKeys(month);
    	DOB.sendKeys(year);
    	
    	
    }
	
	

	
}

