package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;

public class TC05_Verify_Store_Menu_Items extends BaseClass {
	
	@Test
	public void verifyMenuItems()
	{
		HomePage hp= new HomePage(driver);
		hp.printMenuItems();
		boolean act=hp.mainStoreMenuIsDisplayed();
		boolean exp= true;
		Assert.assertEquals(act, exp);
		logger.info("Verified Menu Items");
	}

}
