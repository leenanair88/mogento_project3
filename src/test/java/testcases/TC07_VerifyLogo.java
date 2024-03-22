package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;

public class TC07_VerifyLogo extends BaseClass{
	@Test(priority=1)
	public void VerfiyLogo()
	{
		HomePage hp= new HomePage(driver);
		boolean act=hp.logoDisplayed();
		boolean exp= true;
		Assert.assertEquals(act, exp);
		logger.info("Logo is displayed");
	}
	
	@Test(priority=2)
	public void verifynavigation() {
		HomePage hp= new HomePage(driver);
		String actt=hp.verifynavigationLogo();
		if(actt.equals("Home Page"))
        {
			
			
			Assert.assertTrue(true);
			logger.info("Verified HomePage Title");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info(" HomePage Title Verification failed");
			
		}
		
	}

}
