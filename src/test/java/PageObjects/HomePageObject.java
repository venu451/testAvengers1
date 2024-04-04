package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor)(driver);
	
	public HomePageObject(WebDriver driver,WebDriverWait mywait){
		super(driver,mywait);
	}
	
	@FindBy(xpath="//input[@aria-label='What do you want to learn?']")
	WebElement inp_searchBox;
	
	@FindBy(xpath="//form/div/button[@aria-label='Submit Search'][2]")
	WebElement click_search;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Language']/div/div[2]/div[1]//input")
	WebElement click_language;
	
	@FindBy(xpath="//div[contains(@data-testid,'Beginner')]")
	WebElement click_level;
	
	@FindBy(xpath="//div[@data-testid='active-filter-items']")
	WebElement check_filter;
	
	@FindBy(xpath="//a[@data-track-component='search_card']")
	public List<WebElement> course_list;
	
	public void sendData(String str) {
		inp_searchBox.sendKeys(str);
	}
	
	public void searchClick() {
		js.executeScript("arguments[0].click()",click_search);
	}
	public void clickLevel() {
		scrollIntoView(click_level);
		click_level.click();
	}
	public void clickLang() {
		scrollIntoView(click_language);
		click_language.click();
	}
	public void filterSelectionStatus() {
		mywait.until(ExpectedConditions.visibilityOf(check_filter));
	}
	public void scrollIntoView(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(false);", ele);
	}

}
