package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;


public class TC21_Verify_Cart_Count extends BaseClass{
	@Test
	public void verifyCartCount() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.signin();
		logger.info("Clicked sign in");
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		clp.emailid(emailid);
		logger.info("enetered emailid");
		clp.pasw(passw);
		logger.info("Entered password");
		clp.clicksigin();
		logger.info("Clicked sign in");
		JavascriptExecutor jsx1 = (JavascriptExecutor)driver;
		jsx1.executeScript("window.scrollBy(0,1300)", "");
		
		hp.hoverToProduct();
		logger.info("Mousehovered on product");
		hp.selectSize();
		logger.info("size selected");
		hp.selectColor();
		logger.info("color selected");
		hp.addtoCart();		
		logger.info("Clicked add to cart");
		Thread.sleep(3000);
		hp.clickCart();
		logger.info("Clicked on cart");
		Thread.sleep(2000);
		String act=hp.itemCount();
		if (act.contains("1 Item in Cart")) {
			Assert.assertTrue(true);
			logger.info("Verified the cart count");
		} else {

			Assert.assertTrue(false);
			logger.info("Cart count verification failed");

		}
		
	}

}
