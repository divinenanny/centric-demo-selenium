package sharedResources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Attachment;


public class CreateScreenShot {
      
       @Attachment
       public static byte[] takescreenshot(WebDriver driver,String screenshotname) throws IOException
       {
              TakesScreenshot takescreenshot=(TakesScreenshot)driver;
              File source=takescreenshot.getScreenshotAs(OutputType.FILE);
              FileUtils.copyFile(source, new File("./target/screenshots/"+screenshotname+".png"));
              return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
       }

}