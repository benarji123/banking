package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerEditPage {
  WebDriver ldriver;
	public CustomerEditPage(WebDriver rdriver ) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@CacheLookup
    @FindBy(xpath="/html/body/div[3]/div/ul/li[3]/a")
    public WebElement EditCustomerlink;
	@FindBy(name="cusid")
	public WebElement Customeid;
	@FindBy(name="AccSubmit")
	public WebElement SubmitButton;
}
