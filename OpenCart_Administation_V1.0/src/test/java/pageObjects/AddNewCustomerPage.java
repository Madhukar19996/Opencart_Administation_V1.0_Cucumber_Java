package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddNewCustomerPage extends BasePage {
    
	
	//constructor 
	public AddNewCustomerPage(WebDriver driver) {
		super(driver);
	}
	//Find web elements on the web page
	@FindBy(xpath="//a[normalize-space()='Customers']")	 
	WebElement lnkCustomers_menu;


	@FindBy(xpath="//ul[@id='collapse5']//a[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;

	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")	 
	WebElement btnAddnew;


	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;


	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;


	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;


	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

   
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	//VendorId
  /*
	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;

	@FindBy(id = "Gender_Male")
	WebElement MaleGender;


	@FindBy(id = "Gender_Female")
	WebElement FeMaleGender;


	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;


	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
	*/

	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement btnSave;

	//Actions Methods for web elements

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	public void clickOnCustomersMenu() {
		lnkCustomers_menu.click();
	}

	public void clickOnCustomersMenuItem() {
		lnkCustomers_menuitem.click();
	}

	public void clickOnAddnew() {
		btnAddnew.click();
	}

	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void enterConfPassword(String Confpwd)
	{
	  txtPassword.sendKeys(Confpwd);
	}
	public void enterFirstName(String firstName)
	{
		
		txtFirstname.sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		txtLastname.sendKeys(lastName);
	}

	
	public void enterTelephone(String tele)
	{
		txtTelephone.sendKeys(tele);
	}
  /*
	public void enterCompanyName(String coName)
	{
		txtCompanyName.sendKeys(coName);
	}

	public void enterAdminContent(String content)
	{
		txtAdminContent.sendKeys(content);
	}

	/*public void enterCustomerRoles(String role)  
		{

		}
		
	public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}

	public void enterGender(String gender)
	{
		if(gender.equals("Male"))
		{
			MaleGender.click();
		}
		else if(gender.equals("Female"))
		{
			FeMaleGender.click();
		}
		else//default set Male gender
		{
			MaleGender.click();
		}

	}

    */

	public void clickOnSave()
	{
		btnSave.click();
	}

}



