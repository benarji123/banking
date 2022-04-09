package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPageObject {
	public WebDriver ldriver;
	public HeaderPageObject(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@CacheLookup
	@FindBy(id="psearch")
	public WebElement searchbox;
	@CacheLookup
	@FindBy(xpath="//button[@type='button'and @data-toggle='button']")
	public WebElement searchicon;
	@CacheLookup
	@FindBy(id="btnsubmit")
	public WebElement searchbutton;
	@CacheLookup
	@FindBy(xpath="//table[@id='tbl_a_saleslist']/tbody/tr[1]/td[5]/div/span/span")
	public WebElement tablesalesnumber;
	 @CacheLookup
	 @FindBy(xpath="//table[@id='tbl_a_saleslist']")
	 public WebElement Table;

}
