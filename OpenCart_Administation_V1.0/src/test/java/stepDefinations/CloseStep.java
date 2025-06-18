package stepDefinations;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass {
	
	@Then("close browser")
	public void close_browser() {
		//driver.close();
		driver.quit();
		logger.warn("Browser is closed ");

	}

}