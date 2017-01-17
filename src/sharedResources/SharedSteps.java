package sharedResources;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SharedSteps {
	
	@Test
	public static void openSite(WebDriver driver) {
		driver.get(sharedResources.Variables.URL);
	}
	
	@Test
	public static void loginSite(WebDriver driver) {
		driver.findElement(By.id("BodyContent_TextBoxUsername")).sendKeys("QH-tester");
		driver.findElement(By.id("BodyContent_TextBoxpassword")).sendKeys("QH-testers");
		driver.findElement(By.id("BodyContent_SignInbutton")).click();
	}
}
