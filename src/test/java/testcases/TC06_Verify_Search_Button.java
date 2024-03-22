package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;

public class TC06_Verify_Search_Button extends BaseClass{
	@Test(priority=1)
	public void verifySeachTab()
	{
		HomePage hp= new HomePage(driver);
		
		boolean act=hp.searchEnabled();
		boolean exp= true;
		Assert.assertEquals(act, exp);
	}
	@Test(priority=2)
	public void verifySearchText()
	{
		HomePage hp= new HomePage(driver);
		hp.searchitems("Tops");
		logger.info("Searched for Tops");
		String act=hp.signoutText();
		System.out.println(act);
		if(act.equals("Search results for: 'Tops'"))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Verified Search results for: 'Tops'");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info(" Search results for: 'Tops' Verification failed");

			
		}
	}
	

}
