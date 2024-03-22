package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.HomePage;
import pages.ProductsDetailsPage;

public class TC14_WriteReview_Without_SignIn extends BaseClass{
	@Test
	public void verifyReviewMesaage() throws InterruptedException
	{

		HomePage hp= new HomePage(driver);
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,900)", "");
		hp.clickproduct();
		logger.info("Clicked on product");
		ProductsDetailsPage pdp= new ProductsDetailsPage(driver);
		pdp.clickreview();
		logger.info("Clicked on review");
		JavascriptExecutor jsx1 = (JavascriptExecutor)driver;
		jsx1.executeScript("window.scrollBy(0,1300)", "");
		
		pdp.name("Akku");
		logger.info("Entered Name");
		pdp.summ("My First Review");
		logger.info("Clicked on Review");
		pdp.reviw("Very Good Product");
		logger.info("Entered Review");
		pdp.clickstar();
		
		pdp.submit();
		Thread.sleep(3000);
		String act= pdp.getSuccessmsg();
		if(act.contains("You submitted your review for moderation."))
		{
			Assert.assertTrue(true);
			logger.info("Verified Review success message");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Review success message failed");
			
		}
	
	}

}
