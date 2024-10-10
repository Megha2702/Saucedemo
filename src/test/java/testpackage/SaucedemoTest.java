package testpackage;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.ExcelUtilities;
import baseclasspackage.BaseclassSaucedemo;
import pagepackage.CheckoutPage;
import pagepackage.HomePage;
import pagepackage.ProductPage;
import pagepackage.SaucedemoPage;


public class SaucedemoTest extends BaseclassSaucedemo{

	@Test
	public void testSaucedemo() throws Exception {
		
		String xl = "D:\\Software_testing\\saucedemosheet.xlsx";
		String Sheet = "Sheet1";
		int rowCount = ExcelUtilities.getRowCount(xl, Sheet);
				
		for(int i = 1; i <= rowCount; i++) {
			String username = ExcelUtilities.getCellValue(xl, Sheet, i, 0);
			System.out.println("The username is: "+username);
			String password = ExcelUtilities.getCellValue(xl, Sheet, i, 1);
			System.out.println("The password is: "+password+"\n");
			
			//retrieving and calling methods in SaucedemoPage ie, loginpage
			SaucedemoPage loginpage = new SaucedemoPage (driver);
			loginpage.setValues(username, password);
			loginpage.loginClick();
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//			wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
//			String actualUrl = driver.getCurrentUrl();
//			String expectedUrl = "https://www.saucedemo.com/inventory.html";
//
//			if (!actualUrl.equals(expectedUrl)) {
//			    System.out.println("Access failed to the product page. Current URL: " + actualUrl);
//			    return; 
//			} else {
//			    System.out.println("Access success to the product page : " + actualUrl);
//			} 
			loginpage.clear();
			
			        
			}
		
						
			//retrieving and calling methods in ProductPage
			System.out.println("Product page");
			ProductPage productPage = new ProductPage(driver);
			productPage.message();
			productPage.addProductsToCart();
			System.out.println("Added all products to the cart.");
			productPage.goToCart();
			Thread.sleep(2000);
			
			//calling methods in CheckoutPage
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.checkoutClick();
			checkoutPage.addInformation("Amrita", "Aryan", "53272");
			checkoutPage.clearForm();
			checkoutPage.backNavigation();		
			
			//calling methods in HomePage
			HomePage homePage = new HomePage(driver);
			homePage.logout();
			
	}
	
}
