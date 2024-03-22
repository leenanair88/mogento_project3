package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsDetailsPage {
WebDriver ldriver;
	
	public ProductsDetailsPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement warning;
	
	@FindBy(xpath="//span[@class='base']")
	WebElement productname;
	
	@FindBy(id="tab-label-additional-title")
	WebElement moreinfo;
	
	@FindBy(id="additional")
	List <WebElement> additionalinfo;
	
	@FindBy(id="tab-label-reviews-title")
	WebElement reviewtitle;
	
	
	@FindBy(xpath="//label[@id='Rating_5_label']")
	WebElement tworating;
	
	@FindBy(id="nickname_field")
	WebElement nickname;
	
	@FindBy(id="summary_field")
	WebElement summary;
	
	@FindBy(id="review_field")
	WebElement review;
	
	@FindBy(xpath="//span[normalize-space()='Submit Review']")
	WebElement subbtn;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement succmsg;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement productpagewarning;
	
	@FindBy(xpath="//div[@id='option-label-size-143-item-168']")
	WebElement medium;
	
	@FindBy(xpath="//div[@id='option-label-color-93-item-50']")
	WebElement bluecolour;
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement addcart;
	
	@FindBy(xpath="//div[@id='option-label-size-143-item-169']")
	WebElement sizeLarge;
	
	@FindBy(xpath="//div[@id='option-label-color-93-item-56']")
	WebElement colororange;
	
	
	@FindBy(xpath="//button[@id='product-addtocart-button']")
	WebElement addcartbtn;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement Cart;
	
	@FindBy(xpath="//div[@class='product-item-details']/strong/a")
	WebElement cartproduct;
	
	@FindBy(xpath="//strong[@class='subtitle empty']")
	WebElement cartempty;
	
	@FindBy(xpath="//a[@title='Remove item']")
	WebElement remove;
	
	@FindBy(xpath="//span[normalize-space()='OK']")
	WebElement removeConfirmMsg;
	
	@FindBy(xpath="//div[@class='items-total']")
	WebElement Itemstotal;
	
	
	public String warn()
	{
		String warnmsg=warning.getText();
		return warnmsg;
	}
	
	
	public String productName()
	{
		return productname.getText();
	}
	
	public boolean moreinfoEnabled()
	{
		boolean enb= moreinfo.isEnabled();
		return enb;
	}
	
	public void ClickMoreInfo()
	{
		moreinfo.click();
	}
	
	public void additionalInfo()
	{
		for (WebElement webElement : additionalinfo) {
            String details = webElement.getText();
            System.out.println(details);
        }
	}


	public void clickreview()
	{
		reviewtitle.click();
	}
	
	public void clickstar()
	{
		Actions act= new Actions(ldriver);
		act.moveToElement(tworating).click().build().perform();
		//tworating.click();
	}
	public void name(String Nname)
	{
		nickname.sendKeys(Nname);;
	}
	public void summ(String sum)
	{
		summary.sendKeys(sum);
	}
	
	public void reviw(String rev)
	{
		review.sendKeys(rev);
	}
	
	public void submit()
	{
		subbtn.submit();
	}
	
	public String getSuccessmsg()
	{
		String msg=succmsg.getText();
		return msg;
	}
	
	public String productpagewarn()
	{
		return productpagewarning.getText();
	}
	
	public String gettitle()
	{
		return ldriver.getTitle();
	}
	
	public void chooseSize()
	{
		medium.click();
	}
	
	public void chooseColour()
	{
		bluecolour.click();
	}
	public void addtoCart()
	{
		addcart.click();
	}
	
	public void addproduct()
	{
		sizeLarge.click();
		colororange.click();
		addcartbtn.click();
	}
	
	public void clickCart()
	{
		Cart.click();
	}
	
	public String itemInCart()
	{
		return cartproduct.getText();
	}
	
	public String cartEmptyMessage()
	{
		return cartempty.getText();
	}
	
	public void removeCartItem()
	{
		remove.click();
		//remove.sendKeys(Keys.ENTER);
	}
	
	public void removeConfirm()
	{
		String newWindow = ldriver.getWindowHandle();
		ldriver.switchTo().window(newWindow);
		//Switching to new window
		removeConfirmMsg.click();
		//Switching back to default/main window
		ldriver.switchTo().defaultContent();
		
	}
	
	public String itemCount()
	{
		return Itemstotal.getText();
	}
	
}
