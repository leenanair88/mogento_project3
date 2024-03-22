package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
WebDriver ldriver;
	
	public ProductsPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath="//span[@class='base']")
	WebElement jackettext;
	
	@FindBy(xpath="//a[@class='product-item-link']")
	WebElement producttext;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	WebElement addtocart;
	
	@FindBy(xpath="//a[normalize-space()='Proteus Fitness Jackshirt']")
	WebElement menproducttext;
	
	@FindBy(xpath="//li[1]//div[1]//div[1]//div[3]//div[1]//div[2]//a[1]")
	WebElement wishlist;
	
	public String pagetxt()
	{
		String pgtxt=jackettext.getText();
		return pgtxt;
	}
	
	public String getproText()
	{
		String producttxt=producttext.getText();
		return producttxt;
	}
	
	public void mouseoverproduct()
	{
		 Actions actions = new Actions(ldriver);
	        actions.moveToElement(producttext).perform();
	}
	
	public void addtoCart()
	{
		addtocart.click();
	}
	
	public void mouseovermenproduct()
	{
		 Actions actions = new Actions(ldriver);
	        actions.moveToElement(menproducttext).perform();
	}
	
	public void clickWishlist()
	{
		wishlist.click();
	}
}
