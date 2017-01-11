package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

public class BasicTest {

	public WebDriver driver;

  @Test
  public void main() {
	  // Find the element that has the xpath to the "Akkoord" button in the cookie warning
	  driver.findElement(By.xpath(".//*[@id='cookiebar-top']/div/a")).click();
	  
	  // Find the element that's ID attribute is 'search-input-q'(Search box)
      driver.findElement(By.id("search-input-q")).click();

      // Find the element that's ID attribute is 'search-input-q' (Search box)
      // Enter search term on the element found by above desc.
      driver.findElement(By.id("search-input-q")).sendKeys("testuser_1");
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver","C:\\dev\\tools\\geckodriver\\geckodriver.exe");

	  // Create a new instance of the Firefox driver
      driver = new FirefoxDriver();

      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //Launch the quality tours website
      driver.get("http://qualitytours.centric-tsp.centriconline.nl/");
  }

  @AfterMethod
  public void afterMethod() {
	  // Close the driver
      driver.quit();
  }

}