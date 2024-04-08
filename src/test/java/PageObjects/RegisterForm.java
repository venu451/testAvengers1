package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterForm extends BasePage {
	
	public RegisterForm(WebDriver driver,WebDriverWait mywait){
		super(driver,mywait);
	}
	
	@FindBy(xpath="//input[@id=\"FirstName\"]")
	WebElement fname;
	@FindBy(xpath="//input[@id=\"LastName\"]")
	WebElement lname;
	@FindBy(xpath="//input[@id=\"Email\"]")
	WebElement email;
	@FindBy(xpath="//input[@id=\"Phone\"]")
	WebElement phone;
	@FindBy(xpath="//input[@id='Company']")
	WebElement company;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement submit;
	@FindBy(xpath="//div[@class=\"mktoError\"]")
	WebElement Mess;
	
	//Actions
	public void FirstName() {
//		driver.findElement(fname).sendKeys("Aditya");
		fname.sendKeys("Aditya");
	}
	public void LatName() {
//		driver.findElement(lname).sendKeys("Doddi");
		lname.sendKeys("Doddi");
	}
	public void email() {
//		driver.findElement(Email).sendKeys("!@#$");
		email.sendKeys("!@#$");
	}
	public void PhoneNo() {
//		driver.findElement(phone).sendKeys("9876543210");
		phone.sendKeys("9876543210");
	}
	public void FirstName(String str) {
//		driver.findElement(fname).sendKeys("Aditya");
		fname.clear();
		fname.sendKeys(str);
	}
	public void LatName(String str) {
//		driver.findElement(lname).sendKeys("Doddi");
		lname.clear();
		lname.sendKeys(str);
	}
	public void email(String str) {
//		driver.findElement(Email).sendKeys("!@#$");
		email.clear();
		email.sendKeys(str);
	}
	public void PhoneNo(String str) {
//		driver.findElement(phone).sendKeys("9876543210");
		phone.clear();
		phone.sendKeys(str);
	}
	public void Institution(String str) {
		company.clear();
		company.sendKeys(str);
	}
	
	public void Submitbutton() {
//		driver.findElement(submit).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", submit);
//		submit.click();
	}
	public String Error() {
		mywait.until(ExpectedConditions.visibilityOf(Mess));
         return Mess.getText();
	}
//	public WebElement screenshot() {
//	    driver.findElement(By.xpath("//div[@class=\"mktoFormRow\"][2]"));
//	    return null;
//	
//		
//	}
	public WebElement screenshot1(String str) throws IOException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);", Mess);
		TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
			File trg = new File(".\\screenshots\\"+str+".png");
			FileUtils.copyFile(src, trg);
		return null;
	}
	
}
