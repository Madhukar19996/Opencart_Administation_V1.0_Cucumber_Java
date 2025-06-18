

package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewCustomerPage;
import pageObjects.FilterCustomersPage;
import pageObjects.LoginPage;
import utilities.ReadConfig;

// Child Class of Base Class
public class StepsDefi extends BaseClass {

	@Before("@sanity or @regression")
	public void setup1()
	{
		//initialise logger
		logger = LogManager.getLogger("StepDef");
		// Setting Chrome Options to disable password save pop-up
		ChromeOptions options1 = new ChromeOptions();
		EdgeOptions options2= new EdgeOptions();
		FirefoxOptions options3= new FirefoxOptions();

		// Disable notifications, info bars, and password manager
		options1.addArguments("--disable-notifications");
		options1.addArguments("disable-infobars");
		options1.addArguments("--start-maximized");


		options2.addArguments("--disable-notifications");
		options2.addArguments("disable-infobars");
		options2.addArguments("--start-maximized");

		options3.addArguments("--disable-notifications");
		options3.addArguments("disable-infobars");
		options3.addArguments("--start-maximized");

		// Disable password manager
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options1.setExperimentalOption("prefs", prefs);
		options2.setExperimentalOption("prefs", prefs);
		//	options3.setExperimentalOption("prefs", prefs);
		// Launch Chrome with options
		//options.addArguments("Headless");
		readConfig = new ReadConfig();



		System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();

		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":

			driver = new ChromeDriver();

			break;

		case "msedge":

			driver = new EdgeDriver();

			break;

		case "firefox":

			driver = new FirefoxDriver();

			break;
		default:
			driver = null;
			break;

		}

		logger.fatal("Setup1 executed...");
	}		  

	/*@Before("@regression")
	public void setup2()
	{

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
		System.out.println("Setup method is executed for regression");

	}
	 */
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {



		logginpage = new LoginPage(driver); // Creating LoginPage Object
		addNewCustPg = new AddNewCustomerPage(driver);
		filCustPg=new FilterCustomersPage(driver);
		logger.info("User launch Chrome browser");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String Url) {
		driver.get(Url);
		logger.info("Url opened ");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		logginpage.setEmail(email);
		logginpage.setPassword(pwd);
		logger.info("Email and Password is entered  ");
	}

	@When("Click on Login")
	public void click_on_login()  {
		logginpage.clickLogin();
		logger.info("Login button is clicked");
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
			logger.warn("Test Passed: Login feature page title is matched ");
			Assert.assertTrue(true); // pass
		} else {
			logger.warn("Test Failed: Login feature page title is not matched ");
			Assert.assertTrue(false); // fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		logginpage.clickLogout();
		logger.info("User clicked on logout link ");
	}

	/*
	@Then("close browser")
	public void close_browser() {
		//driver.close();
		//logger.warn("Browser is closed ");

	}
	 */

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
			logger.info("user can view dashboard test passed.");
			Assert.assertTrue(true); // pass
		} else {
			logger.warn("user can't view dashboard test failed.");
			Assert.assertTrue(false); // fails
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		logger.info("customer menu clicked");
		addNewCustPg.clickOnCustomersMenu();

	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		logger.info("customer menu item clicked");
		addNewCustPg.clickOnCustomersMenuItem();

	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		logger.info("Clicked on Add new button");
		addNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Customers";
		if (actualTitle.equals(expectedTitle)) {
			logger.info("User can view Add new customer page- passed");

			Assert.assertTrue(true); // pass
		} else {
			logger.warn("User can't view Add new customer page- failed");
			Assert.assertTrue(false); // fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addNewCustPg.enterFirstName("Madhukar");
		addNewCustPg.enterLastName("Pandey");

		//addNewCustPg.enterEmail("TestingSdet@gmail.com");

		addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustPg.enterTelephone("9987675543");
		addNewCustPg.enterPassword("demo");
		addNewCustPg.enterConfPassword("demo");
		logger.info("customer information entered");
	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
		logger.info("clicked on Save button");
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
			logger.info("User can view confirmation message - passed");
			org.testng.Assert.assertTrue(true); // pass
		} else {
			logger.warn("User can't view confirmation message - failed");
			org.testng.Assert.assertTrue(false); // fail
		}
	}
	//=================================Filter By Customer Email===============================

	@When("Enter customer EMail")
	public void enter_customer_e_mail() {

		filCustPg.enterEmailAdd("test1@test.com");
		logger.info("Entered customer EMail");
	}

	@When("Click on filter button")
	public void click_on_filter_button() {
		filCustPg.clickOnfilterButton();
		logger.info("Clicked on filter button");
	}  

	@Then("User should found Email in the Filter table")
	public void user_should_found_email_in_the_filter_table() {
		String expectedEmail = "test1@test.com";

		//Assert.assertTrue(filCustPg.filterCustomerByEmail(expectedEmail));



		if( filCustPg.filterCustomerByEmail(expectedEmail) ==true)
		{
			org.testng.Assert.assertTrue(true);
			logger.info("Test case is passed");


		}
		else {

			org.testng.Assert.assertTrue(false);
			logger.warn("Test case is failed");

		}
	} 

	//=========================Filter customer by name=========================

	@When("Enter customer Name")
	public void enter_customer_first_name() {
		filCustPg.enterFirstName("Billy Brooks");
		logger.info("Entered customer Name");
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
			org.testng.Assert.assertTrue(true);
			logger.info("Test Case is Passed ");
		}
		else
			Assert.assertTrue(false);
		logger.warn("Test Case is Failed ");

	}
	//@After()
	public void teardown1(Scenario  sc)
	{

		System.out.println("Teardown method is executed");
		if(driver != null) {
			if(sc.isFailed())
			{

				//Convert web driver object to TakeScreenshot

				String fileWithPath = ".\\screenshots\\failedScreenshot.png";
				TakesScreenshot scrShot =((TakesScreenshot)driver);

				//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

				//Move image file to new destination
				File DestFile=new File(fileWithPath);

				//Copy file at destination

				try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		driver.quit();

	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {

		// this is for cucumber junit report

		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			final byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
			driver.quit();

		}
		

	}
	/*@After()
	public void teardown2()
	{

		System.out.println("Teardown method is executed");
		driver.quit();

	}

	@AfterStep
	public void afterstepmethoddemo()
	{

		System.out.println("This is a after step....");


	}

	@BeforeStep
	public void beforestepmethoddemo()
	{

		System.out.println("This is a before step....");


	}
	 */

}
