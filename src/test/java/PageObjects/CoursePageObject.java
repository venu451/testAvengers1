package PageObjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class CoursePageObject extends BasePage {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public CoursePageObject(WebDriver driver,WebDriverWait mywait){
		super(driver,mywait);
	}
	
	@FindBy(xpath="//div[@data-e2e='key-information']//section/div[2]/div[1]/div[1]")
	WebElement text_rating;
	@FindBy(xpath="//div[@data-e2e='key-information']//section/div/div[1]/div/div/div[1]")
	WebElement text_rating_sec;
	@FindBy(xpath="//div[@data-e2e='key-information']//section/div[2]/div[3]/div[1]")
	WebElement text_hours;
	@FindBy(xpath="//div[@data-e2e='key-information']//section/div/div[2]/div/div/div[1]")
	WebElement text_hours_sec;
	@FindBy(tagName="h1")
	WebElement text_course;
	
	public String ratingText() {
		js.executeScript("arguments[0].scrollIntoView();", text_rating);
		String rating = text_rating.getText();
		return rating;
	}
	public String optRatingText() {
		js.executeScript("arguments[0].scrollIntoView();", text_rating_sec);
		String rating = text_rating_sec.getText();
		return rating;
	}
	
	public String hoursText() {
		js.executeScript("arguments[0].scrollIntoView();", text_hours);
		String hours = text_hours.getText();
		return hours;
	}
	public String optHoursText() {
		js.executeScript("arguments[0].scrollIntoView();", text_hours_sec);
		String hours = text_hours_sec.getText();
		return hours;
	}
	
	public String courseText() {
		String course = text_course.getText();
		return course;
	}
	
	public int durationInHours(String hours) {
		int res = 0;
		if(hours.contains("months")){
		    int mon = Integer.valueOf(hours.substring(0,hours.indexOf(" months")));
		    int h = Integer.valueOf(hours.substring(hours.indexOf("at ")+3,hours.indexOf(" hours")));
		    res = (mon*4)*h;
		}
		else{
		    int h = Integer.valueOf(hours.substring(0,hours.indexOf(" hours")));
		    res = h;
		}
		return res;
	}
}
