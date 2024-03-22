package testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.ProductsDetailsPage;
import pages.ProductsPage;

public class TC20_Remove_Items_From_Cart extends BaseClass{
	@Test
	public void VerifyRemobeItemsFromCart() throws InterruptedException
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
	Thread.sleep(3000);
	pdp.clickCart();
	logger.info("Clicked on cart");
	Thread.sleep(3000);
	pdp.removeCartItem();
	logger.info("removed item from cart");
	Thread.sleep(2000);
	//driver.switchTo().alert().accept();
	pdp.removeConfirm();
	logger.info("Accepted the confirmation message");
	String act=pdp.cartEmptyMessage();
	if (act.contains("You have no items in your shopping cart.")) {
		Assert.assertTrue(true);
		logger.info("Itema successfully removed from cart");
	} else {

		Assert.assertTrue(false);
		logger.info("remove from cart failed");

	}
	
	
	}

}
