package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.ProductsPage;

public class TC08_VerifyMousehover_On_Storemenu_Items  extends BaseClass{
	@Test(priority=1)
	
	public void verifyMenuItems()
	{
		HomePage hp= new HomePage(driver);
		hp.printMenuItems();
		boolean act=hp.mainStoreMenuIsDisplayed();
		boolean exp= true;
		Assert.assertEquals(act, exp);
		logger.info("Verified Menu Items");
	}
	
	@Test(priority=2)
	public void MouseHover() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		hp.hoverToMenMenu();
		logger.info("Mousehover on Men Menu");
		hp.hoverToTops();
		logger.info("Mousehover on Men Tops");
		hp.clickOnJackets();
		logger.info("clicked on Jackets");
	}
	@Test(priority=3)
	public void verifyNavigationPageTitle()
	{
		ProductsPage pp= new ProductsPage(driver);
		String act=pp.pagetxt();
		if(act.equals("Jackets"))
        {
			
			
			Assert.assertTrue(true);
			logger.info("Verified the heading: jackets");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("heading: jackets verification failed");
			
		}
		
	}
}
