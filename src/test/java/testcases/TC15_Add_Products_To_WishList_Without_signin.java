package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.ProductsPage;

public class TC15_Add_Products_To_WishList_Without_signin extends BaseClass{
	@Test(priority=1)
	public void VerifyPageTitle() throws InterruptedException {
		
		HomePage hp= new HomePage(driver);
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		hp.hoverToMenMenu();
		logger.info("Mousehovered on Men Menu");
		hp.hoverToTops();
		logger.info("Mousehovered on Tops Menu");
		hp.clickOnJackets();
		logger.info("Clicked on jackets");
		ProductsPage pp= new ProductsPage(driver);
		pp.mouseovermenproduct();
		logger.info("Mousehovered on Product");
		pp.clickWishlist();
		logger.info("Clicked on WishedList");
		String pgtitle= clp.gettitle();
		if(pgtitle.contains("Customer Login"))
		{
			Assert.assertTrue(true);
			logger.info("Customer Login Page Title Verified");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Customer Login Page Title Verification failed");
			
		}
		
	}
	
	@Test(priority=2)
	public void VerifyErrorMessage()
	{
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		
		String pgtitle= clp.getErrorMsg();
		if(pgtitle.contains("You must login or register to add items to your wishlist."))
		{
			Assert.assertTrue(true);
			logger.info("Verified the warning message");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("warning message verification failed");
		}
		
	}

}
