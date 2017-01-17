package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sharedResources.BaseTest;

public class LoginTest extends BaseTest {

	@DataProvider(name = "logins")
	public static Object[][] logins() {
		return new Object[][] { 
			//username, password, verwacht resultaat
			{ "username", "password", false }, 
			{ "username", "", false }, 
			{ "", "password", false },
			{ "", "", false },
			{ "QH-tester", "QH-testers", true },
			{ " QH-tester", " QH-testers", false },
			{ "QH-tester ", "QH-testers ", false },
			{ "$%^&*%%%@", "password", false },
			{ "username", "%&^#%&&%", false },
			{ "ditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusernameditiseenhelelangeusername", "password", false },
			{ "QH-tester", "ditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoordditiseenheellangpaswoord", false } };
	}

	@Test(dataProvider = "logins")
	public void login(String username, String password, Boolean outcome) {
		WebDriver driver = threadLocalDriver.get();
		sharedResources.SharedSteps.openSite(driver);
		driver.findElement(By.id("BodyContent_TextBoxUsername")).sendKeys(username);
		driver.findElement(By.id("BodyContent_TextBoxpassword")).sendKeys(password);
		driver.findElement(By.id("BodyContent_SignInbutton")).click();

		if (outcome) {
			AssertJUnit.assertEquals("Failed login text is incorrect",
					"Gebruik onze vluchten zoeker om de goedkoopste vluchten te vinden bij onze deelnemende maatschappijen. Vergeet niet uw hotel en/of auto en/of rondreis vervolgens bij ons te boeken.",
					driver.findElement(By.xpath(".//*[@id='tekstSearchFlight']/p")).getText());
		} else {
			AssertJUnit.assertEquals("Failed login text is incorrect",
					"U bent op deze pagina terechtgekomen omdat u onjuiste inloggegevens hebt ingevoerd of u moet eerst inloggen alvorens u verder kunt navigeren binnen de site.",
					driver.findElement(By.xpath(".//*[@id='tekst']/p")).getText());
		}
	}
}
