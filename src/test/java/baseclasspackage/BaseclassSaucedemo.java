package baseclasspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseclassSaucedemo {

	public static WebDriver driver;
	String url = "https://www.saucedemo.com";
	
	@BeforeClass
	
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
			
	
}
