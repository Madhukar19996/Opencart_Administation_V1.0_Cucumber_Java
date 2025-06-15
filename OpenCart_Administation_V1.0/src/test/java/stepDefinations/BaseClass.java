package stepDefinations;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPage;
import pageObjects.FilterCustomersPage;
import pageObjects.LoginPage;

// Parent class
public class BaseClass {
	
	public WebDriver driver;
	public LoginPage logginpage;
	public AddNewCustomerPage addNewCustPg;
	public FilterCustomersPage filCustPg;
	
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}

}
