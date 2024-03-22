package library;

import java.time.Duration;


import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger= LogManager.getLogger(BaseClass.class);
	ReadConfig rc = new ReadConfig();

	String url = rc.getBaseUrl();
	String browser = rc.getBrowserl();
	
	public String emailid = rc.getEmail();
	public String passw = rc.getPassword();
	@BeforeTest
	public void initialiazeBrowser() 
	{
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// open url

			driver.get(url);
			logger.info("url opened");
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(url);
			//Logger.info("url opened");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
			//Logger.info("url opened");
			break;
		default:
			driver = null;
			break;
		}
		
	}
	public String generateEmailid() 
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	
  @AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}

