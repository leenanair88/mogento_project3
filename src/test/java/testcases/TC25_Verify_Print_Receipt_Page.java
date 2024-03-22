package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CheckoutPage;
import pages.CustomerLoginPage;
import pages.HomePage;

public class TC25_Verify_Print_Receipt_Page extends BaseClass{
	
	@Test
	public void verifyPrintReceipt() throws InterruptedException, AWTException
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
		cp.printrept();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	       
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                	 driver.switchTo().window(ChildWindow);
	 	             String act= cp.proName();
	 	           
	 	   		if (act.equals("Radiant Tee")) {
	 	   			Assert.assertTrue(true);
	 	   		logger.info("Verified the product name from oder receipt");
	 	   		} else {

	 	   			Assert.assertTrue(false);
	 	   		logger.info("Order receipt verification failed");

	 	   		}
	                }
	               
	}

}
	}
