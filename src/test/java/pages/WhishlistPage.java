package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhishlistPage {

WebDriver ldriver;
	
	public WhishlistPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement wishlistsuccessmsg;
	
	@FindBy(xpath="//button[@data-role='tocart']//span[contains(text(),'Add to Cart')]")
	WebElement addtocart;
	
	
	
	
	public String succmsgWishList()
	{
		return wishlistsuccessmsg.getText();
	}
	
	public void clickAddtocart()
	{
		addtocart.click();
	}
}
