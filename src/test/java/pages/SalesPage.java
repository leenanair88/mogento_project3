package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage {
	
WebDriver ldriver;
	
	public SalesPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//span[@class='base']")
	WebElement pageheading;
	
	@FindBy(xpath="//div[@class='blocks-promo']/a/img")
	WebElement womensdeals;
	
	public String pageheadings()
	{
		String heading=pageheading.getText();
		return heading;
		
	}
	
	public void clicksaleimage()
	{
		womensdeals.click();
	}
	
	

}
