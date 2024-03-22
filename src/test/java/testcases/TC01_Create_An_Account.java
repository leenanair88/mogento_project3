package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CreateAccountPage;
import pages.HomePage;

public class TC01_Create_An_Account extends BaseClass{
	
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
	public void createAccount() throws IOException, InterruptedException
	{
		HomePage hp= new HomePage(driver);
		CreateAccountPage cpg= new CreateAccountPage(driver);
		
		hp.clickCreteAccount();
		cpg.enterFirstname("Kichu");
		logger.info("Entered Firstname");
		cpg.enterLastname("akku");
		logger.info("Entered Second Name");
		cpg.enterEmail(generateEmailid() + "@gmail.com");
		logger.info("Entered Email ID");
		cpg.enterPassword("12345678@12345@abc");
		logger.info("Entered Password");
		cpg.confirmPass("12345678@12345@abc");
		logger.info("Entered Confirm Password");
		cpg.clickCreateAccount();
		Thread.sleep(3000);
		String act= cpg.successMessage();
		System.out.println(act);
		if(act.equals("Thank you for registering with Main Website Store."))
		{
			
			
			Assert.assertTrue(true);
			logger.info("Verified Registration success msg");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Registration success msg failed");
		}
	}

}
