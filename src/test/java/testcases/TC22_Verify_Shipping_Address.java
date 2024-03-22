package testcases;

import org.testng.annotations.Test;

import library.BaseClass;
import pages.CheckoutPage;
import pages.CheckoutPage;
import pages.HomePage;

public class TC22_Verify_Shipping_Address extends BaseClass {
	@Test
	public void verifyshippingAddres() throws InterruptedException
	{
		TC21_Verify_Cart_Count tc21= new TC21_Verify_Cart_Count();
		tc21.verifyCartCount();
		HomePage hp = new HomePage(driver);
		hp.clickProccded();
		logger.info("Clicked on procced to checkout");
		Thread.sleep(6000);
		CheckoutPage cp= new CheckoutPage(driver);
		cp.address();
		logger.info("Verified the address");
	}

}
