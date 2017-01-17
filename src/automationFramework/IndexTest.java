package automationFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sharedResources.BaseTest;

public class IndexTest extends BaseTest {

	@DataProvider(name = "pagelinks")
	public static Object[][] pageLinks() {
		return new Object[][] { 
				// link om te klikken, verwachte pagina titel
				{ ".//*[@id='menuItems']/ul/li[1]/a/span", "Home | QualityTours" },
				{ ".//*[@id='menuItems']/ul/li[2]/a/span", "LogIn | QualityTours" },
				{ ".//*[@id='menuItems']/ul/li[3]/a/span", "Under Construction | QualityTours" },
				{ ".//*[@id='menuItems']/ul/li[4]/a/span", "Under Construction | QualityTours" },
				{ ".//*[@id='menuItems']/ul/li[5]/a/span", "Under Construction | QualityTours" } };
	}

	@Test
	public void indexPageTitle() {
		WebDriver driver = threadLocalDriver.get();
		sharedResources.SharedSteps.openSite(driver);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		AssertJUnit.assertEquals("Home | QualityTours page title is not visible: ", "Home | QualityTours",
				driver.getTitle());
	}

	@Test(dataProvider = "pagelinks")
	public void indexPageLinks(String link, String pagetitle) {
		WebDriver driver = threadLocalDriver.get();
		sharedResources.SharedSteps.openSite(driver);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(link)).click();
		AssertJUnit.assertEquals(pagetitle + " (the page title) is not visible", pagetitle, driver.getTitle());
	}
}