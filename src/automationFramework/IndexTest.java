package automationFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sharedResources.BaseTest;

public class IndexTest extends BaseTest {

	@Features("Index")
	@Stories("Main page")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void indexPage() {
		WebDriver driver = threadLocalDriver.get();
		sharedResources.SharedSteps.openSite(driver);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(driver.getTitle(),
				"Home | Quality Tours", "Home | Quality Tours page title is not visible: ");
	}
}