package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.ProductsDetailsPage;
import pages.ProductsPage;

public class TC19_Verify_Cart_Items extends BaseClass{
	
	@Test
	public void verifyCartItems() throws InterruptedException
	{
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
		logger.info("Mousehovered on men product");
		pp.addtoCart();
		logger.info("Clicked on add to cart");
		ProductsDetailsPage pdp= new ProductsDetailsPage(driver);
		Thread.sleep(2000);
		pdp.addproduct();
		pdp.clickCart();
		logger.info("Clicked on cart");
		Thread.sleep(2000);
		String act=pdp.itemInCart();
		if (act.contains("Proteus Fitness Jackshirt")) {
			Assert.assertTrue(true);
			logger.info("Verified the product title");
		} else {

			Assert.assertTrue(false);
			logger.info("Product title verification failed");

		}
		
	}

}
