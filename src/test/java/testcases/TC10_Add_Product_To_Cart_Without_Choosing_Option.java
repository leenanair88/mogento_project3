package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.ProductsDetailsPage;
import pages.ProductsPage;

public class TC10_Add_Product_To_Cart_Without_Choosing_Option extends BaseClass {
	

	@Test
	public void verifyWarningMessage() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		ProductsPage pp= new ProductsPage(driver);
		ProductsDetailsPage pdp= new ProductsDetailsPage(driver);
		hp.searchitems("jackets");
		logger.info("searched for jackets");
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,500)", "");
		pp.mouseoverproduct();
		logger.info("Mousehovered on Hotsellers");
		pp.addtoCart();
		logger.info("clicked add to cart");
		Thread.sleep(5000);
		String act=pdp.warn();
		System.out.println(act);
		if(act.contains("You need to choose options for your item."))
		{
			Assert.assertTrue(true);
			logger.info("Warning message verification passed");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Warning message verification failed");
			
		}
		
		
	}

}
