package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalesModule {
	WebDriver ldriver;

	
	public SalesModule(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@CacheLookup
	@FindBy(name="btnsubmit")
	public WebElement loginButton;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"mi_a_sales\"]/a")
	public WebElement saleslink;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a")
	public WebElement addsalebutton;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x_Sales_Number\"]")
	public WebElement salesnumber;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x_Customer_ID\"]")
	public WebElement customerIdDropDown;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x1_Supplier_Number\"]")
	public WebElement salenumberDropDown;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x1_Stock_Item\"]")
	public WebElement StockItemsDropDown;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x1_Sales_Quantity\"]")
	public WebElement Quantity;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x_Discount_Percentage\"]")
	public WebElement DiscountPercentage;
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x_Tax_Percentage\"]")
	public WebElement TaxPercentage;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x_Total_Payment\"]")
	public WebElement ToatalPayment;
	
	@CacheLookup
	@FindBy(xpath="//button[@id='btnAction']")
	public WebElement FirtstAddButon;
	@CacheLookup
	@FindBy(xpath="//button[text()='OK!']")
	public WebElement SecondAddButton;
	@CacheLookup
	@FindBy(xpath="(//button[text()='OK'])[6]")
	public WebElement ThirdAddbuttton;
	
	public void CustomerIdDropDown(String VisibleText) {
		Select sl=new Select(customerIdDropDown);
		sl.selectByVisibleText(VisibleText);
	}
	public void SalesNumberDropDown(String VisibleText) {
		Select sl=new Select(salenumberDropDown);
		sl.selectByVisibleText(VisibleText);
	}
	public void StockItemsDropDown(String VisibleText) {
		Select sl=new Select(StockItemsDropDown);
		sl.selectByVisibleText(VisibleText);
	}
	@CacheLookup
	@FindBy(xpath="//*[@id=\"x1_Sales_Total_Amount\"]")
	
	public WebElement Refresh;
	@CacheLookup
	@FindBy(xpath="(//button[text()='OK'])[6]")
	public WebElement fourthAdd;
	@CacheLookup
	@FindBy(name="x_Sales_Date")
	public WebElement date;
	@CacheLookup
	@FindBy(xpath="//a[text()='Back to master table']")
	public WebElement backtomaster;
	@CacheLookup
	@FindBy(id="x_Sales_Number")
	public WebElement salesnum;
	
	
	
	
}
