package pagepackage;

import java.time.Duration
;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//locate addtocart buttons

	@FindBy(xpath = "//*[@class='btn btn_primary btn_small btn_inventory ']")
	List<WebElement> addToCartButtons;
		
	//locate cart button
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartButton;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Product page constructor!");
	}
	
	public void message() {
		System.out.println("This is a cart page.");
	}
	public void addProductsToCart() throws InterruptedException {
		
		for (WebElement button : addToCartButtons) {
			
			wait.until(ExpectedConditions.elementToBeClickable(button)).click();
			System.out.println("The product is added to the cart!");
		}
		
	}
	
	
	public void goToCart() {
		cartButton.click();
		System.out.println("The add to cart button has been clicked!");
	}
}
