package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.SalesPage;

public class TC11_Verify_Sales_Page extends BaseClass {
	@Test(priority=1)
	public void verifySalesPage()
	{
		HomePage hp= new HomePage(driver);
		hp.clicksales();
		SalesPage sp= new SalesPage(driver);
		String act=sp.pageheadings();
		if(act.contains("Sale"))
		{
			Assert.assertTrue(true);
			logger.info("Verified sales page heading");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("sales page heading verification failed");
			
		}
	}
	@Test(priority=2)
	public void verifyWomenSalesPage()
	{
		SalesPage sp= new SalesPage(driver);
		sp.clicksaleimage();
		logger.info("Clicked on sales page image");
		String act=sp.pageheadings();
		
		if(act.contains("Women Sale"))
		{
			Assert.assertTrue(true);
			logger.info("Women sale page heading verified");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Women sale page heading verification failed");
			
		}
	}
}
