package sharedResources;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SharedSteps {
  @Test
  public static void openSite(WebDriver driver) {
	  driver.get(sharedResources.Variables.URL);
  }
}
