package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public static WebDriverWait mywait;
	
	public BasePage(WebDriver driver,WebDriverWait mywait) {
		this.driver = driver;
		this.mywait = mywait;
		PageFactory.initElements(driver, this);
	}
}
