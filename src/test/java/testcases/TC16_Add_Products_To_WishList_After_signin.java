package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.WhishlistPage;

public class TC16_Add_Products_To_WishList_After_signin extends BaseClass{
	@Test(priority=1)
	public void VerifyWishListSuccesssMesage() throws InterruptedException  {
		
		HomePage hp= new HomePage(driver);
		hp.signin();
		logger.info("Clicked sign in");
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		clp.emailid(emailid);
		logger.info("enetered emailid");
		clp.pasw(passw);
		logger.info("Entered password");
		clp.clicksigin();
		logger.info("Clicked sign in");
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
		Thread.sleep(3000);
		WhishlistPage wp= new WhishlistPage(driver);
		String succmessage=wp.succmsgWishList();
		if(succmessage.contains("Proteus Fitness Jackshirt has been added to your Wish List. Click here to continue shopping."))
		{
			Assert.assertTrue(true);
			logger.info("Success message verification passed");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Success message verification failed");
			
		}
		
		
	}
		
		
	

}
