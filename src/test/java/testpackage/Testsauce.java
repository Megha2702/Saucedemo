package testpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.ExcelUtilities;
import baseclasspackage.BaseclassSaucedemo;
import pagepackage.CheckoutPage;
import pagepackage.HomePage;
import pagepackage.ProductPage;
import pagepackage.SaucedemoPage;

public class Testsauce  extends BaseclassSaucedemo{

	WebDriver driver;
	
	@Test
	public void test() throws InterruptedException {
		String xl = "D:\\Software_testing\\saucedemosheet.xlsx";
		String Sheet = "Sheet1";
		
		int rowCount = ExcelUtilities.getRowCount(xl, Sheet);
		for(int i = 1; i <= rowCount; i++) {
			String username = ExcelUtilities.getCellValue(xl, Sheet, i, 0);
			System.out.println("The username is: "+username);
			String password = ExcelUtilities.getCellValue(xl, Sheet, i, 1);
			System.out.println("The password is: "+password);
			SaucedemoPage login  = new SaucedemoPage(driver);
			login.setValues(username, password);
		}
			
		
		// Wait for the page to load (this might be an implicit wait or WebDriverWait)
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	 // Check if we can access the products page
	    String expectedUrl = "https://www.saucedemo.com/inventory.html";
	    String actualUrl = driver.getCurrentUrl();

	    if (!actualUrl.equals(expectedUrl)) {
	        System.out.println("Failed to access the product page. Current URL: " + actualUrl);
	        return; 
	    } else {
	        System.out.println("Successfully connected to the product page: " + actualUrl);
	    }

	    
	    ProductPage product = new ProductPage(driver);
	    product.addProductsToCart();
	    product.goToCart();
	    product.message();

	    // Navigate to cart and checkout
	    CheckoutPage checkout = new CheckoutPage(driver);
	    checkout.checkoutClick();
	    checkout.addInformation("Shilpa", "Akhil", "34576");
	    checkout.backNavigation();
	    
	    // Logout
	    HomePage home = new HomePage(driver);
	    home.logout();
	}
		
	}

