package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	public void Submitbutton() {
//		driver.findElement(submit).click();
		submit.click();
	}
	public String Error() {
         return Mess.getText();
	}
//	public WebElement screenshot() {
//	    driver.findElement(By.xpath("//div[@class=\"mktoFormRow\"][2]"));
//	    return null;
//	
//		
//	}
	public WebElement screenshot1() throws IOException {
		// TODO Auto-generated method stub
		WebElement pic= driver.findElement(By.xpath("//div[@class=\"mktoFormRow\"][2]"));
		 File src = pic.getScreenshotAs(OutputType.FILE);
			File trg = new File(".//screenshots/pic.png");
			FileUtils.copyFile(src, trg);
		return null;
	}
	
}
