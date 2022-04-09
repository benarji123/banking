package TestCaseforSales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.banking.pageObject.HeaderPageObject;
import com.banking.pageObject.SalesModule;

public class TC_SalesCreation_001  extends Base1 {
	@Test
	public void saleAdd() throws Throwable {
		ExtentSparkReporter re=new ExtentSparkReporter(this.getClass().getName()+".html");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(re);
		ExtentTest test=extent.createTest("Sales");
		SalesModule sales=new SalesModule(driver);
		sales.loginButton.click();
		sales.saleslink.click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		sales.addsalebutton.click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		String saleNumber=sales.salesnum.getAttribute("value");
		FileWriter w=new FileWriter("./salesnumber/num.txt");
		BufferedWriter bw=new BufferedWriter(w);
		bw.write(saleNumber);
		bw.flush();
		
		
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','2000/05/28 ')", sales.date);
		sales.CustomerIdDropDown("Second Customer");
		sales.SalesNumberDropDown("Fourth Supplier");
		sales.StockItemsDropDown("Tenth Stock Item");
		sales.Quantity.clear();
		sales.Quantity.sendKeys("1");
		Thread.sleep(4000);;
		sales.Refresh.sendKeys(Keys.F5);
		
		sales.DiscountPercentage.clear();
	   
		sales.DiscountPercentage.sendKeys("2");
		sales.TaxPercentage.clear();
		sales.TaxPercentage.sendKeys("3");
		
		sales.ToatalPayment.clear();
	
		sales.ToatalPayment.sendKeys("50");
		//WebDriverWait wait =new WebDriverWait(driver, 4);
		//wait.until(ExpectedConditions.elementToBeClickable(sales.FirtstAddButon));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", sales.FirtstAddButon);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",sales.SecondAddButton);
		Thread.sleep(400);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",sales.ThirdAddbuttton);
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();",sales.fourthAdd);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		sales.backtomaster.click();
		HeaderPageObject h=new HeaderPageObject(driver);
		//if(!h.searchbox.isDisplayed());
		
		//WebDriverWait wait =new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.elementToBeClickable(h.searchbutton));
		h.searchicon.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	    FileReader fr=new FileReader("./salesnumber/num.txt");
		BufferedReader bf=new BufferedReader(fr);
	    String info= bf.readLine();
	    h.searchbox.sendKeys(info);
	    Thread.sleep(3000);
	 
	    h.searchicon.click();
	   List<WebElement> l= h.Table.findElements(By.tagName("tr"));
	  int r= l.size();
	  for(int i=1; i<r;i++ ) {
		String info1=  driver.findElement(By.xpath("//table[@id='tbl_a_saleslist']/tbody/tr["+i+"]/td[5]/div/span/span")).getText();
		
		  if(info.equalsIgnoreCase(info1)) {
			 
			  System.out.println(info+"   "+info1);
			  test.pass("test got passed");
			  Assert.assertEquals(info, info1,"not matched");
			  break;
		  }
		  
		  
	  }
	  extent.flush();
	  
	 
	
		
		
} 
	public void validate() throws Throwable{
	
		
	}

}

