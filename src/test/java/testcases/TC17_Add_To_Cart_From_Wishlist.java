package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.ProductsDetailsPage;
import pages.ProductsPage;
import pages.WhishlistPage;

public class TC17_Add_To_Cart_From_Wishlist extends BaseClass {
	@Test(priority=1)
	public void verifyProductDetailspage() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		CustomerLoginPage clp = new CustomerLoginPage(driver);
		ProductsPage pp = new ProductsPage(driver);
		hp.signin();
		logger.info("Clicked sign in");
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
		pp.mouseovermenproduct();
		logger.info("Mousehovered on jackets");
		pp.clickWishlist();
		logger.info("Clicked on WishedList");
		pp.mouseovermenproduct();
		logger.info("Mousehovered on Men Menu");
		WhishlistPage wp = new WhishlistPage(driver);
		wp.clickAddtocart();
		logger.info("Clicked on add to cart");
		ProductsDetailsPage pdp = new ProductsDetailsPage(driver);
		String act = pdp.gettitle();
		if (act.contains("Proteus Fitness Jackshirt")) {
			Assert.assertTrue(true);
			logger.info("Product title verified");
		} else {

			Assert.assertTrue(false);
			logger.info("Product title verification failed");

		}
		

	}
	
	@Test(priority=2)
	public void verifyWaring() throws InterruptedException
	{
		ProductsDetailsPage pdp = new ProductsDetailsPage(driver);
		Thread.sleep(5000);
		String act = pdp.productpagewarn();
	
		if (act.contains("You need to choose options for your item.")) {
			Assert.assertTrue(true);
			logger.info("warning message verified");
		} else {

			Assert.assertTrue(false);
			logger.info("warning message verification failed");

		}
	}

	@Test(priority=3)
	public void verifyAddCartMessage() throws InterruptedException
	{
		ProductsDetailsPage pdp = new ProductsDetailsPage(driver);
		pdp.chooseSize();
		logger.info("size selected");
		pdp.chooseColour();
		logger.info("color selected");
		pdp.addtoCart();
		logger.info("Clicked add to cart");
		Thread.sleep(2000);
		WhishlistPage wp= new WhishlistPage(driver);
		Thread.sleep(5000);
		String succmessage=wp.succmsgWishList();
		System.out.println(succmessage);
		if(succmessage.contains("You added Proteus Fitness Jackshirt to your shopping cart."))
		{
			Assert.assertTrue(true);
			logger.info("success message verified");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("success message verification failed");
			
		}
	}
	

}
