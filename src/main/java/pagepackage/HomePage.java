package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//locate hamburger menu button
	@FindBy(id = "react-burger-menu-btn")
	WebElement hamburgerMenuButton;
	
	//locate logout button
	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		hamburgerMenuButton.click();
		logoutButton.click();
	}
}
