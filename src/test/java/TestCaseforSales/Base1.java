package TestCaseforSales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base1 {
	public WebDriver driver;

	//@Parameters({"browser" ,"openapp"})
	@BeforeClass
	public void setUp() {
    	
   
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("http://projects.qedgetech.com/webapp/login.php");
    	//driver.manage().window().maximize();
    	
    		
    	}
    	
	
	@AfterClass(enabled = false)
	public void tearDown() {
		
		driver.quit();
		

}
}
