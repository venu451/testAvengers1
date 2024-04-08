package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadytotransformObject extends BasePage {
	//Constructor
	public ReadytotransformObject(WebDriver driver,WebDriverWait mywait){
		super(driver,mywait);
	}
	//Locators
//	By Enterprise=By.xpath("//a[text()=\"For Enterprise\"]");
//	By Solutions= By.xpath("//a[text()=\"Solutions\"]");
//	By CoursersForCampus=By.xpath("//p[text()=\"Coursera for Campus\"]");
//	By ContactUs=By.xpath("//div/a/span[text()=\"Contact us\"]");
	
	@FindBy(xpath="//div[@aria-label='Banner']/a[1]")
	WebElement forIndividuals;
	@FindBy(xpath="//a[text()=\"For Enterprise\"]")
	WebElement Enterprise;
	@FindBy(xpath="//a[text()=\"Solutions\"]")
	WebElement Solutions;
	@FindBy(xpath="//p[text()=\"Coursera for Campus\"]")
	WebElement CoursersForCampus;
	@FindBy(xpath="//div/a/span[text()=\"Contact us\"]")
	WebElement ContactUs;
	@FindBy(xpath="//div[@class='mktoError']")
	public WebElement mess;
	@FindBy(xpath="//div[@class='mktoError']/preceding::label[1]")
	public WebElement relLabel;
	//Actions
	public void ForIndividualsClick() {
		forIndividuals.click();
	}
	public void ForEnterprise() {
//		driver.findElement((By) Enterprise).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Enterprise);
	}
	public void SolutionClick() {
//		driver.findElement((By) Solutions).click();	
		Solutions.click();
	}
	public void Courses() {
//		driver.findElement((By) CoursersForCampus).click();	
		CoursersForCampus.click();
	}
	public void Contactclick() {
//		driver.findElement((By) ContactUs).click();	
		ContactUs.click();	
	}
	public void scrolldown() throws InterruptedException {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(false);", Enterprise);
	}
	
	
	
}
