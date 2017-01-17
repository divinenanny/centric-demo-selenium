package sharedResources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setUpDriver() {
		System.setProperty("webdriver.gecko.driver","C:\\dev\\tools\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\dev\\tools\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		threadLocalDriver.set(driver);
	}

	@AfterMethod
	public void closeDriver() throws IOException {
		WebDriver driver = threadLocalDriver.get();
		driver.quit();
	}

}
