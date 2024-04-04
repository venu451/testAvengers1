package BasePackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait mywait;
	
	@BeforeSuite
	public void driverSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@AfterSuite
	public void driverClose() {
		driver.quit();
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;//creating an instance of an TakeScreenshot Interface
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetPath = new File(target);
		src.renameTo(targetPath);
		return target;
	}
}
