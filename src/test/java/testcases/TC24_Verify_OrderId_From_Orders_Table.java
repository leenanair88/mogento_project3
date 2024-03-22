package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CheckoutPage;
import pages.CreateAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;

public class TC24_Verify_OrderId_From_Orders_Table extends BaseClass{
	
	@Test
	public void verifyOrderId() throws InterruptedException
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
		Thread.sleep(5000);
		CreateAccountPage cap= new CreateAccountPage(driver);
		cap.verifyOrderinOrderTable();
		logger.info("Verified the order Id from the order Table");
	}

}
