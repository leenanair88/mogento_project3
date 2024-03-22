package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	String path = "E:\\Eclipse New Codes\\my workspace\\project3_testingboardmogento\\Configuration\\config.properties";

	// constructor
	public ReadConfig() {
		try {
			// initializing object of properties
			prop = new Properties();
			// creating an object of fileinputstream to read the file

			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String value=prop.getProperty("baseurl");
	
		if(value!=null)
		{
			return value;
		}
		else {
			throw new RuntimeException("URL not specified in config file");
		}
		
	}
	
	public String getBrowserl()
	{
		String value=prop.getProperty("browser");
	
		if(value!=null)
		{
			return value;
		}
		else {
			throw new RuntimeException("browser not specified in config file");
		}
		
	}
	
	public String getEmail()
	{
		String email = prop.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}

	public String getPassword()
	{
		String password = prop.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}

}
