package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CreateAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;

public class TC03_Edit_Account_Info extends BaseClass{
	
	@Test(priority=1)
	public void verifyCustomerLogin()
	{
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		HomePage hp= new HomePage(driver);
		hp.signin();
		
		String pagact= clp.gettext();
		
		if(pagact.equals("Customer Login"))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Customer Login Text Verification Passed");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Customer Login Text Verification Failed");
			
		}
		
	}
	@Test(priority=2)
	public void VerifyEditText() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		CreateAccountPage cap= new CreateAccountPage(driver);
		clp.emailid(emailid);
		logger.info("Entered Email ID");
		clp.pasw(passw);
		logger.info("Entered password");
		clp.clicksigin();
		logger.info("clicked signin");
		hp.clickdropdown();
		logger.info("clicked dropdown button");
		cap.editaccnt();
		logger.info("clicked on My account");
		cap.clearFields();
		cap.enterFirstname("Paru");
		logger.info("Entered First Name");
		cap.enterLastname("s");
		logger.info("Entered Last Name");
		cap.clickSave();
		logger.info("clicked saved");
		Thread.sleep(3000);
		String actual=cap.accounteditMsg();

		if(actual.equals("You saved the account information."))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Verified Account edit message");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Account edit message verification failed");
			
		}
		
	
		
	}
	@Test(priority=3)
	public void VerifySignout()
	{
		HomePage hp= new HomePage(driver);
		
	    hp.clickdropdown();
	    logger.info("clicked dropdown button");
		hp.signout();
		logger.info("clicked signout");
		
	}

}
