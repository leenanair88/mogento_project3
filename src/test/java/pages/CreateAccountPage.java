package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	
	WebDriver ldriver;
	
	public CreateAccountPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="firstname")
	WebElement Fname;
	
	@FindBy(id="lastname")
	WebElement Lname;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="password")
	WebElement passw;
	
	@FindBy(id="password-confirmation")
	WebElement passconfirm;
	
	@FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement createaccntbtn;
	
	@FindBy(xpath="//div[@class='page messages']/div/div/div/div")
	WebElement succssmsg;
	
	@FindBy(linkText="Edit")
	WebElement editaccnt;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement savebtn;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement acctedittext;
	
	@FindBy(xpath="//a[normalize-space()='My Orders']")
	WebElement myorder;
	
	@FindBy(id="my-orders-table")
	List <WebElement> tableRows;
	
	@FindBy(xpath="//div[@class='checkout-success']//p[1]")
	WebElement OrderID;
	
	
	@FindBy(xpath="//div[@class='panel header']//button[@type='button']")
	WebElement dropdown;

	@FindBy(linkText="My Account")
	WebElement myaccount;
	
	//Your wish list has been shared.
	//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']
	
	
	
	public void enterFirstname(String fn)
	{
		Fname.sendKeys(fn);
	}
	public void enterLastname(String ln)
	{
		Lname.sendKeys(ln);
	}
	public void enterEmail(String emailadd)
	{
		email.sendKeys(emailadd);
	}
	public void enterPassword(String pw)
	{
		passw.sendKeys(pw);
	}
	public void confirmPass(String pw)
	{
		passconfirm.sendKeys(pw);
	}
		
	public void clickCreateAccount()
	{
		createaccntbtn.click();
	}
	
	public String successMessage()
	{
		String msg=succssmsg.getText();
		return msg;
	}
	
	public void editaccnt()
	{
		editaccnt.click();
	}
	
	public void clearFields()
	{
		Fname.clear();
		Lname.clear();
	}
	
	public void clickSave()
	{
		savebtn.click();
	}
	
	public String accounteditMsg()
	{
		String edittext=acctedittext.getText();
		return edittext;
	}
	
	public void clickMyorder()
	{
		myorder.click();
		
	}

		
	public boolean verifyOrderinOrderTable()
	{
		String orderdetail= OrderID.getText();
		System.out.println(orderdetail);
		String[] arrOfStr = orderdetail.split(":", 2);
		//System.out.println(arrOfStr[1]);
		String orderno=arrOfStr[1].replaceAll("[.]", "");
		System.out.println(orderno);
		//float f=Float.parseFloat(tt);
		//System.out.println(f);
	//	return orderno;
		dropdown.click();
		myaccount.click();
		myorder.click();
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();

		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			//System.out.println("Searching row:" +i );

			WebElement orders = ldriver.findElement(By.xpath("//table[@id='my-orders-table']//tbody/tr[" + i  + "]/td[1]"));
			String actualorderid = orders.getText();
			System.out.println("The Order ID from table: "+actualorderid);
			if(actualorderid.equals(orderno))
			{
				found=true;
			}

		}
		
		return found;
	}

}
