package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.ProductsPage;

public class TC09_Verify_Searched_Product_Title extends BaseClass {
	
	@Test(priority=1)
	public void verifySearchText()
	{
		HomePage hp= new HomePage(driver);
		hp.searchitems("jackets");
		String act=hp.signoutText();
		System.out.println(act);
		if(act.equals("Search results for: 'jackets'"))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Verified Search results");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Search results Verification failed ");
			
		}
	}
	@Test(priority=2)
	public void verifyProductTitle()
	{
		ProductsPage pp= new ProductsPage(driver);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,500)", "");
		String txtpro=pp.getproText();
		if(txtpro.contains("Jacket"))
		{
			Assert.assertTrue(true);
			logger.info("Verified Product title text with search result");
		}
		else
		{
			
			Assert.assertTrue(false);
			
		}
	}

}
