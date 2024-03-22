package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;

public class TC04_Verify_Welcome_Message extends BaseClass{
	
	@Test
	public void verifyWelcomeMsg()
	{
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		HomePage hp= new HomePage(driver);
		hp.signin();
		clp.emailid(emailid);
		logger.info("Entered Email ID");
		clp.pasw(passw);
		logger.info("Entered password");
		clp.clicksigin();
		logger.info("clicked signin");
		String act=hp.welcomemsg();
		System.out.println(act);
		if(act.equals("Welcome, Paru s!"))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Verified Welcome message");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Welcome message verification failed");
		}
		
	    hp.clickdropdown();
	    logger.info("clicked dropdown button");
		hp.signout();
		logger.info("clicked signout");
		
	}

}
