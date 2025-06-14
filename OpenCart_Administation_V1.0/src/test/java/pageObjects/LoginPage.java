package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
	  super(driver);
	}

	@FindBy(xpath = "//input[@id='input-username']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//i[@class='fa fa-key']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//header[@id='header']//li[2]//a[1]")
	WebElement btnLogout;


	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

	

}
