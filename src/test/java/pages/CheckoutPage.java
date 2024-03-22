package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
WebDriver ldriver;
	
	public CheckoutPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//div[@class='shipping-address-item selected-item']")
	List <WebElement> Addresslist;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement next;
	
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	WebElement placeorder;
	
	@FindBy(xpath="//span[@class='base']")
	WebElement placeorderSucessmsg;
	
	@FindBy(xpath="//a[@class='action print']")
	WebElement printrecipt;
	
	@FindBy(xpath="//span[normalize-space()='Continue Shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath="//a[@class='action print']")
	WebElement printreceipt;
	
	@FindBy(xpath="//strong[@class='product name product-item-name']")
	WebElement productnameinprintrcpt;	
	
	
	public void address()
	{
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Paru S \n"
				+ "street, town, xxxxx \n"
				+ "pune, South Australia 56789 \n"
				+ "Australia\n"
				+ "8955444436");
//		expectedResult.add("street, town, xxxxx");
//		expectedResult.add("pune, South Australia 56789");
//		expectedResult.add("Australia");
//		expectedResult.add("8955444436");
	
		System.out.println("Expected Shipping Address :");
		System.out.println(expectedResult.size());
		 for (int i = 0; i < expectedResult.size(); i++)
		 {
		      System.out.println(expectedResult.get(i));
		  }
		List<String> actualResult = new ArrayList<String>();
		List<WebElement> address=Addresslist;
		System.out.println();
		System.out.println("Actual Shipping Address :");
		
		for(WebElement geteachtext:address)
			
		{
			String addressdel= geteachtext.getText();
			
			System.out.println(addressdel);
			
		}
				
		System.out.println(address.size());
		for (int j=0; j<address.size(); j++){
		    actualResult.add(address.get(j).getText());
		}
		
		for(int i=1;i<expectedResult.size();i++) {
		    if(actualResult.get(i).equals(expectedResult.get(i))) {
		        System.out.println("Shipping Address is same as expected");
		    }else {
		        System.out.println("Shipping Address is diffrent from expected"+actualResult.get(i));
		    }
		}
	}
	
	public void ClickNext()
	{
		next.click();
	}
	
	public void clickPlaceorder()
	{
		placeorder.click();
	}
	
	public String SuccessmsgPlaceorder()
	{
		return placeorderSucessmsg.getText();
	}
	public void clickcountinueShopping()
	{
		continueshopping.click();
	}
	
	public void printrept()
	{
		printreceipt.click();
		
	}
	
	public String proName()
	{
		return productnameinprintrcpt.getText();
	}
}
