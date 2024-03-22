package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.ProductsDetailsPage;

public class TC13_Verify_More_Information_Tab extends BaseClass {
	
	@Test(priority=1)
	public void verifyMoreIfo()
	{
		HomePage hp= new HomePage(driver);
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,900)", "");
		hp.clickproduct();
		logger.info("Clicked on product");
		ProductsDetailsPage pdp= new ProductsDetailsPage(driver);
		boolean act=pdp.moreinfoEnabled();
		boolean exp= true;
		Assert.assertEquals(act, exp);
		logger.info("More Info Tab is enabled");
		
	}
	@Test(priority=2)
	public void printMoreInfo()
	{
		ProductsDetailsPage pdp= new ProductsDetailsPage(driver);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,600)", "");
		pdp.ClickMoreInfo();
		logger.info("Clicked on more info");
		pdp.additionalInfo();
		logger.info("Addition info of the product displaed in console");
	}

}
