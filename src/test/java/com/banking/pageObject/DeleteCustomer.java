package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {
   WebDriver ldriver;
   public DeleteCustomer(WebDriver rdriver) {
	// TODO Auto-generated constructor stub
	   ldriver=rdriver;
	   PageFactory.initElements(rdriver, this);
	   
} 
   @CacheLookup
   @FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
   public WebElement CustomerDeleteLink;
   @CacheLookup
   @FindBy(name="cusid")
	public WebElement Customeid;
   @CacheLookup
	@FindBy(name="AccSubmit")
	public WebElement SubmitButton;
} 
