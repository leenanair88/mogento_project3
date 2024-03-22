package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CheckoutPage;
import pages.CustomerLoginPage;
import pages.HomePage;

public class TC23_Place_Order extends BaseClass{
	
	@Test
	public void verifyPlaceOrder() throws InterruptedException
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
		Thread.sleep(5000);
		hp.clickCart();
		logger.info("Clicked on cart");
		Thread.sleep(4000);
		hp.clickProccded();
		logger.info("Clicked on proceed to checkout");
		Thread.sleep(10000);
		CheckoutPage cp= new CheckoutPage(driver);
	
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		cp.ClickNext();
		logger.info("Clicked Next");
		Thread.sleep(7000);
		cp.clickPlaceorder();
		logger.info("Clicked on place order");
		Thread.sleep(4000);
		String act=cp.SuccessmsgPlaceorder();
		System.out.println(act);
		if (act.contains("Thank you for your purchase!")) {
			Assert.assertTrue(true);
			logger.info("Verified the success message");
		} else {

			Assert.assertTrue(false);
			logger.info("Success message verification failed");

		}
		cp.clickcountinueShopping();
		logger.info("Clicked on countinue shopping");
	}

}
