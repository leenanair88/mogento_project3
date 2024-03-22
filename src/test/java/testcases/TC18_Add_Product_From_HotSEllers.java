package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;

public class TC18_Add_Product_From_HotSEllers extends BaseClass{
	
	@Test
	public void VerifyAddCartFromHotsellers() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		JavascriptExecutor jsx1 = (JavascriptExecutor)driver;
		jsx1.executeScript("window.scrollBy(0,1300)", "");
		
		hp.hoverToProduct();
		logger.info("mouse hovered on product");
		hp.selectSize();
		logger.info("size selected");
		hp.selectColor();
		logger.info("color selected");
		hp.addtoCart();
		logger.info("Clicked add to cart");
		Thread.sleep(2000);
		String act = hp.addCartMessage();
		if (act.contains("You added Radiant Tee to your shopping cart.")) {
			Assert.assertTrue(true);
			logger.info("success message for add to cart verified");
		} else {

			Assert.assertTrue(false);
			logger.info("success message verification failed");

		}
		
	}

}
