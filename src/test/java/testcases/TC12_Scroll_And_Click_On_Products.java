package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.ProductsDetailsPage;

public class TC12_Scroll_And_Click_On_Products extends BaseClass{
	
	@Test
	public void verifyProductPage()
	{
		HomePage hp= new HomePage(driver);
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,900)", "");
		hp.clickproduct();
		logger.info("Clicked on product");
		ProductsDetailsPage pdp= new ProductsDetailsPage(driver);
		String act= pdp.productName();
		if(act.contains("Radiant Tee"))
		{
			Assert.assertTrue(true);
			logger.info("Product Name verified");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Product Name verification failed");
			
		}
		
	}

}
