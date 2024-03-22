package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
WebDriver ldriver;
	
	public CustomerLoginPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[@class='base']")
	WebElement cuslogintext;
	
	@FindBy(id="email")
	WebElement emailid;
	
	@FindBy(id="pass")
	WebElement psw;
	
	@FindBy(id="send2")
	WebElement signinbtn;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement wishlisterrormsg;
	
	
	public String gettext()
	{
		String txt=cuslogintext.getText();
		return txt;
	}

	public void emailid(String mailid)
	{
		emailid.sendKeys(mailid);
	}
	public void pasw(String pass)
	{
		psw.sendKeys(pass);
	}
	public void clicksigin()
	{
		signinbtn.click();
	}
	
	public String gettitle()
	{
		return ldriver.getTitle();
	}

	public String getErrorMsg()
	{
		return wishlisterrormsg.getText();
	}
}
