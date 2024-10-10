package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;
	
	//locate checkout button
	@FindBy(id = "checkout")
	WebElement checkoutButton;
	
	//locate first name in the form
	@FindBy(id = "first-name")
	WebElement firstName;
	
	//locate last name in the form
	@FindBy(id = "last-name")
	WebElement lastName;
	
	//locate postal code in the form
	@FindBy(id = "postal-code")
	WebElement postalCode;
	
	//locate continue button
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Click checkout
	public void checkoutClick() {
		checkoutButton.click();
	}
	
	//Add details in the form
	public void addInformation(String fn, String ln, String pc) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		postalCode.sendKeys(pc);
		continueButton.click();
	}
	
	//clear fields
	public void clearForm() {
		firstName.clear();
		lastName.clear();
		postalCode.clear();
	}
	
	public void backNavigation() {
		driver.navigate().to("https://www.saucedemo.com/");
	}
}
