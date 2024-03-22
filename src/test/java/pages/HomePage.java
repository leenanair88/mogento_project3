package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Create an Account")
	WebElement accntcreate;
	
	@FindBy(linkText="Sign In")
	WebElement signin;
	
	@FindBy(xpath="//div[@class='panel header']//button[@type='button']")
	WebElement dropdown;

	@FindBy(linkText="Sign Out")
	WebElement signout;
	
	@FindBy(linkText="My Account")
	WebElement myaccount;
	
	@FindBy(xpath="//span[@class='base']")
	WebElement signouttxt;
	
	@FindBy(xpath="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Paru s!']")
	WebElement welcome;
	
	@FindBy(xpath="//*[@id='store.menu']")
	WebElement menuitems;
	
	
	@FindBy(xpath="//*[@id='store.menu']")
	List <WebElement> Listmenuitems;
	
	@FindBy(id="search")
	WebElement searchtab;
	
	@FindBy(xpath="//a[@aria-label='store logo']//img")
	WebElement logo;
	
	@FindBy(id="ui-id-3")
	WebElement whatsnew;
	
	@FindBy(xpath="//*[@id='ui-id-17']/span[2]")
	WebElement mentop;
	
	@FindBy(xpath="//*[@id='ui-id-19']")
	WebElement jacketsMenProducts ;
	
	@FindBy(xpath="//span[normalize-space()='Men']")
	WebElement men;
	
	@FindBy(linkText="Sale")
	WebElement sale;
	
	@FindBy(xpath="//img[@alt='Radiant Tee']")
	WebElement radianttee;

	@FindBy(xpath="//div[@class='swatch-opt-1556']//div[@id='option-label-size-143-item-167']")
	WebElement size;

	@FindBy(xpath="//div[@id='option-label-color-93-item-56']")
	WebElement color;

	@FindBy(xpath="//li[1]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]")
	WebElement addtocarts;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement messageaddcart;
	
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement cart;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement proccedtocheckout;
	
	@FindBy(xpath="//div[@class='items-total']")
	WebElement Itemstotal;
	
	public String pageTitle()
	{
		String title=ldriver.getTitle();
		return title;
	}
	
	public void clickCreteAccount()
	{
		accntcreate.click();
	}
	
	public void signin()
	{
		signin.click();
	}
	
	public void clickdropdown()
	{
		dropdown.click();
	}
	
	public void signout()
	{
		signout.click();
	}
	
	public String signoutText()
	{
		String signottxt=signouttxt.getText();
		return signottxt;
	}
	
	public void clickmyaccount() {
		myaccount.click();
		
	}
	
	public String welcomemsg()
	{
		String txt=welcome.getText();
		return txt;
	}
	
	public boolean mainStoreMenuIsDisplayed() {
      
		boolean menu=menuitems.isDisplayed();
		return menu;
    }
	
	public void printMenuItems() {
		for (WebElement webElement : Listmenuitems) {
            String name = webElement.getText();
            System.out.println(name);
        }
	}
	
	
	public boolean searchEnabled()
	{
		boolean seah=searchtab.isEnabled();
		return seah;
	}
	public void searchitems(String serch)
	{
		searchtab.sendKeys(serch);
		searchtab.sendKeys(Keys.ENTER);
		
	}
	
	public boolean logoDisplayed()
	{
		boolean logo1=logo.isDisplayed();
		return logo1;
	}
	
	public String verifynavigationLogo()
	{
		whatsnew.click();
		logo.click();
		String tt=ldriver.getTitle();
		return tt;
	}
	
	 public void hoverToMenMenu() throws InterruptedException {
	        Thread.sleep(500);
	        Actions actions = new Actions(ldriver);
	        actions.moveToElement(men).perform();
	    }

	    public void hoverToTops() {
	      
	        Actions actions = new Actions(ldriver);
	        actions.moveToElement(mentop).build().perform();
	    }
	    
	    public void clickOnJackets() {
	       
	    	jacketsMenProducts.click();
	    }
	    
	    public void clicksales()
	    {
	    	sale.click();
	    }
	    
	    public void clickproduct()
	    {
	    	radianttee.click();
	    	
	    }
	    
	    public void hoverToProduct() throws InterruptedException {
	        Thread.sleep(500);
	        Actions actions = new Actions(ldriver);
	        actions.moveToElement(radianttee).perform();
	    }
	    
	    public void selectSize()
	    {
	    	size.click();	
	    }
	
	    public void selectColor()
	    {
	    	color.click();
	    }
		
		public void addtoCart()
		{
			addtocarts.click();
		}
		
		public String addCartMessage()
		{
			return messageaddcart.getText();
		}
		
		public void clickCart()
		{
			cart.click();
		}
		
		public void clickProccded()
		{
			proccedtocheckout.click();
		}
		
		public String itemCount()
		{
			return Itemstotal.getText();
		}
		
}
