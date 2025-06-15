package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterCustomersPage extends BasePage {

	//public WebDriver driver;
	public FilterCustomersPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailAdd;

	@FindBy(xpath="//button[@id='button-filter']")
	WebElement filterBtn;

	@FindBy(xpath="//table[@class='table table-bordered table-hover']")
	WebElement filterResult;

	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr")
	List<WebElement> tableRows;

	/*@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr[1]/td")
	List<WebElement> tableColumns;*/

	@FindBy(xpath="//input[@id='input-name']")
	WebElement customerName;

	/*@FindBy(xpath="//input[@id='input-ip']")
	WebElement IP_address;
	*/

	//action method to enter email address
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}

	//action method to perform click action on search button
	public void clickOnfilterButton()
	{
		filterBtn.click();

	}


	public boolean filterCustomerByEmail(String email)
	{
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();


		//total no. of columns
		//int ttlColumns = tableColumns.size();

		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			System.out.println("Searching row:" +i );

			WebElement webElementEmail = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + i  + "]/td[3]"));
			String actualEmailAdd = webElementEmail.getText();
			System.out.println(actualEmailAdd);

			if(actualEmailAdd.equals(email))
			{
				found=true;
			}


		}

		return found;

	}

	//======================Filter Customer By Name
	//action method to enter Customer name
	public void enterFirstName(String CustomerNameText)
	{
		customerName.sendKeys(CustomerNameText);
	}

	//action method to enter IP address
	
	/*
	public void enterLastName(String IP)
	{
		IP_address.sendKeys(IP);
	}
	*/

	public boolean filterCustomerByName(String name)
	{
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();


		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			WebElement webElementName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[" + i  + "]/td[2]"));
			String actualName = webElementName.getText();

			if(actualName.equals(name))
			{
				found=true;
				break;
			}


		}

		return found;

	}
}	


