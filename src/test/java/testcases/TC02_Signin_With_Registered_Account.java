package testcases;

import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CustomerLoginPage;
import pages.HomePage;

public class TC02_Signin_With_Registered_Account extends BaseClass {
	//public static Logger logger= LogManager.getLogger(TC02_Signin_With_Registered_Account.class);
	@Test(priority=1)
	public void verifyhomePage() throws IOException
	{
		HomePage hp= new HomePage(driver);
	String acttitle=hp.pageTitle();
	//String exp= "Home Page";
	if(acttitle.equals("Home Page"))
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
	@Test(priority=2)
	public void verifyCustomerLogin()
	{
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		HomePage hp= new HomePage(driver);
		hp.signin();
		
		String pagact= clp.gettext();
		
		if(pagact.equals("Customer Login"))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Verified Customer Login");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info(" Customer Login Verification failed");
			
		}
		
	}
	@Test(priority=3)
	public void VerifySignout()
	{
		HomePage hp= new HomePage(driver);
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		clp.emailid(emailid);
		logger.info("Entered Email ID");
		clp.pasw(passw);
		logger.info("Entered password");
		clp.clicksigin();
		logger.info("clicked signin");
		hp.clickdropdown();
		logger.info("clicked dropdown button");
		hp.signout();
		logger.info("User signed Out");
		String act=hp.signoutText();
		if(act.equals("You are signed out"))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Signed Out Text Verification Passed");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Signed Out Text Verification failed");
			
		}
	}

}
