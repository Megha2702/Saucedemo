package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//login page

public class SaucedemoPage {
	
	WebDriver driver;
	
	//locate username
	@FindBy(name = "user-name")
	WebElement sauceUsername;
	
	//locate password
	@FindBy(id = "password")
	WebElement saucePassword;
	
	//locate login
	@FindBy(name = "login-button")
	WebElement sauceLogin;
	
	public SaucedemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory .initElements(driver, this);
	}
	
	public void setValues(String username, String password) {
		sauceUsername.sendKeys(username);
		saucePassword.sendKeys(password);
	}
	
	public void loginClick() {
		sauceLogin.click();
	}
	
	public void clear() {
		sauceUsername.clear();
		saucePassword.clear();
		System.out.println("The username and password are refreshed and cleared!");
	}
}
