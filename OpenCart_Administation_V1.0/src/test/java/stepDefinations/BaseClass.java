package stepDefinations;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPage;
import pageObjects.FilterCustomersPage;
import pageObjects.LoginPage;
import utilities.ReadConfig;

// Parent class
public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage logginpage;
	public AddNewCustomerPage addNewCustPg;
	public FilterCustomersPage filCustPg;
	static Logger logger;
	public ReadConfig readConfig;
	
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}

}
