package StepDefinations;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BaseClass;
import io.cucumber.java.*;

public class Hooks {
	public static WebDriver driver;
	public static WebDriverWait mywait;
	
	@BeforeAll
	public static void initializeDriver() throws IOException {
		driver = BaseClass.driverSetup();
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@AfterAll
	public static void tearDown() throws IOException {
		BaseClass.driverClose();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] ss = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(ss, "image/png", scenario.getName());
		
	}
}
