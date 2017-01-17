package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sharedResources.BaseTest;

public class BookFlightTest extends BaseTest {

	@DataProvider(name = "singleTrips")
	public static Object[][] singleTrips() {
		return new Object[][] { 
			//number of passengers, vertrek plaats, vertrek maand, vertrek dag, bestemming, service level, airline
			{"1", "Amsterdam", "Januari", "1", "Berlijn", "0", "No Preference"},
			{"2", "Berlijn", "Februari", "5", "Calcutta", "1", "KLM Royal Dutch Airelines"},
			{"3", "Calcutta", "Maart", "10", "Durtmond", "2", "Lufthansa Airways"},
			{"4", "Durtmond", "April", "15", "Frankfurt", "0", "SwissAir"},
			{"1", "Frankfurt", "Mei", "20", "HongKong", "1", "Singapore Airlines"},
			{"2", "HongKong", "Juni", "25", "Tokyo", "2", "Kuwait Airlines"},
			{"3", "Tokyo", "Juli", "30", "Winnipeg", "0", "China Airlines"},
			{"4", "Winnipeg", "Augustus", "3", "Zürich", "1", "EasyJet"},
			{"1", "Amsterdam", "September", "7", "Zürich", "2", "Britisch Airways"},
			{"2", "Berlijn", "Oktober", "13", "Winnipeg", "0", "IranAir"}
			};
		}
	
	@Test(dataProvider = "singleTrips")
	public void findFlightSingle(String passengers, String vertrekPlaats, String vertrekDatumMaand, String vertrekDatumDag, String bestemming, String service, String airline) {
		WebDriver driver = threadLocalDriver.get();
		sharedResources.SharedSteps.openSite(driver);
		sharedResources.SharedSteps.loginSite(driver);

		Select passengerSelect = new Select(driver.findElement(By.id("BodyContent_DropDownListPassagiers")));
		passengerSelect.selectByValue(passengers);
		
		Select vertrekSelect = new Select(driver.findElement(By.id("BodyContent_DropDownListVertrek")));
		vertrekSelect.selectByValue(vertrekPlaats);
		
		WebDriverWait waitVertrekMaand = new WebDriverWait(driver, 200);
		waitVertrekMaand.until(ExpectedConditions.elementToBeClickable(By.id("BodyContent_DropDownListVertrekMaand")));
		
		Select vertrekDatumMaandSelect = new Select(driver.findElement(By.id("BodyContent_DropDownListVertrekMaand")));
		vertrekDatumMaandSelect.selectByValue(vertrekDatumMaand);
		
		Select vertrekDatumDagSelect = new Select(driver.findElement(By.id("BodyContent_DropDownListVertrekDag")));
		vertrekDatumDagSelect.selectByValue(vertrekDatumDag);
		
		Select bestemmingSelect = new Select(driver.findElement(By.id("BodyContent_DropDownListBestemming")));
		bestemmingSelect.selectByValue(bestemming);
		
		WebDriverWait waitService = new WebDriverWait(driver, 100);
		waitService.until(ExpectedConditions.elementToBeClickable(By.id("BodyContent_RadioButtonListServiceClass_" + service)));
		
		driver.findElement(By.id("BodyContent_RadioButtonListServiceClass_" + service)).click();
		
		Select luchtvaartmaatschappijSelect = new Select(driver.findElement(By.id("BodyContent_DropDownListAirlines")));
		luchtvaartmaatschappijSelect.selectByValue(airline);
		
		driver.findElement(By.id("BodyContent_ButtonVerzenden")).click();
		
		AssertJUnit.assertEquals("Resultaat van vlucht zoeken is incorrect",
				"Kies een vlucht uit onderstaande vluchtenschema.",
				driver.findElement(By.xpath(".//*[@id='tekstSelectFlight']/p")).getText());
	}
}
