
package stepDefinations;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import pageObjects.AddNewCustomerPage;
import pageObjects.FilterCustomersPage;
import pageObjects.LoginPage;

public class StepsDefi {

	public WebDriver driver;
	public LoginPage logginpage;
	public AddNewCustomerPage addNewCustPg;
	public FilterCustomersPage filCustPg;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		// Setting Chrome Options to disable password save pop-up
		ChromeOptions options = new ChromeOptions();

		// Disable notifications, info bars, and password manager
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");

		// Disable password manager
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);

		// Launch Chrome with options
		//options.addArguments("Headless");
		driver = new ChromeDriver(options);
		

		logginpage = new LoginPage(driver); // Creating LoginPage Object
		addNewCustPg = new AddNewCustomerPage(driver);
		filCustPg=new FilterCustomersPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String Url) {
		driver.get(Url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		logginpage.setEmail(email);
		logginpage.setPassword(pwd);
	}

	@When("Click on Login")
	public void click_on_login()  {
		logginpage.clickLogin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String exp_title) {
		String actual_title = driver.getTitle();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (actual_title.equals(exp_title)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		logginpage.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	//========================Add New Customer==============================

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard";
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // fail
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomersMenu();
		
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustPg.clickOnCustomersMenuItem();
		
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Customers";
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addNewCustPg.enterFirstName("Madhukar");
		addNewCustPg.enterLastName("Pandey");
		addNewCustPg.enterEmail("TestingSdet@gmail.com");
		addNewCustPg.enterTelephone("9987675543");
		addNewCustPg.enterPassword("demo");
		addNewCustPg.enterConfPassword("demo");
	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
		String bodytagText = driver.findElement(By.tagName("Body")).getText();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bodytagText.contains(expectedConfirmationMessage)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // fail
		}
	}
	//=================================Filter By Customer Email===============================
	
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		
		filCustPg.enterEmailAdd("test1@test.com");
	}

	@When("Click on filter button")
	public void click_on_filter_button() {
		filCustPg.clickOnfilterButton();
	}  

	@Then("User should found Email in the Filter table")
	public void user_should_found_email_in_the_filter_table() {
		String expectedEmail = "test1@test.com";

		//Assert.assertTrue(filCustPg.filterCustomerByEmail(expectedEmail));
        
		
		
		if( filCustPg.filterCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
			

		}
		else {
			
			Assert.assertTrue(false);

		}
	} 
		
		//=========================Filter customer by name=========================

		@When("Enter customer Name")
		public void enter_customer_first_name() {
			filCustPg.enterFirstName("Billy Brooks");
		}

		

		@Then("User should found name in the Filter table")
		public void user_should_found_name_in_the_search_table() {
			String expectedName = "Billy Brooks";
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			if( filCustPg.filterCustomerByName(expectedName) ==true)
			{
				Assert.assertTrue(true);
			}
			else
				Assert.assertTrue(false);

	}
}
