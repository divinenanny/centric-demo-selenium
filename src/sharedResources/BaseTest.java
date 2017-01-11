package sharedResources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setUpDriver() {
		WebDriver driver = new FirefoxDriver();
		threadLocalDriver.set(driver);
	}

	@AfterMethod
	public void closeDriver(ITestResult result) throws IOException {
		WebDriver driver = threadLocalDriver.get();
		
		if(ITestResult.FAILURE == result.getStatus())
        {
			sharedResources.CreateScreenShot.takescreenshot(driver, result.getName());
			driver.quit();
        }
		
		driver.quit();
	}

}
