package StepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePackage.BaseClass;
import PageObjects.CoursePageObject;
import PageObjects.HomePageObject;
import io.cucumber.java.en.*;

public class CourseInfo extends BaseClass{
	
	HomePageObject hpo;
	CoursePageObject cpo;
	
	@Given("the user is navigated to the coursera home page")
	public void the_user_is_navigated_to_the_coursera_home_page() {
	    WebElement logo = driver.findElement(By.xpath("//a[@data-click-key='front_page.front_page_story.click.navigation_meta_nav_Individuals']"));
	    log.info("The User is navigated to the coursera Home Page");
	    Assert.assertTrue(logo.isDisplayed(),"The user hasn't navigated to the home page");
	}

	@When("user enters input field as {string} and clicks on search button")
	public void user_enters_input_field_as_and_clicks_on_search_button(String string) {
		hpo = new HomePageObject(driver,mywait);
		log.info("The user sends the input as "+string+" as input to search Box");
		hpo.sendData(string);
		hpo.searchClick();
		log.info("The user clicks on the search button");
		Assert.assertTrue(!hpo.course_list.isEmpty(),"The List Of Cources are not displayed. Enter the Valid Course Name");
	}

	@When("select the language as english and select the level as Beginner")
	public void select_the_language_as_english_and_select_the_level_as_beginner() {
		hpo.clickLang();
		log.info("The user selected the language as English");
		hpo.clickLevel();
		log.info("The user selected the level as Beginner");
		try {
			hpo.filterSelectionStatus();
			log.info("The status of the filters is applied");
			Assert.assertTrue(true,"The level and language is updated");
		}
		catch(Exception e) {
			log.info("The filter status is not updated");
			Assert.fail("The level or Language is not updated properly"); 
		}
	}

	@Then("the user should print the first two courses title, rating and hours of learning")
	public void the_user_should_print_the_first_two_courses_title_rating_and_hours_of_learning() throws IOException {
		cpo = new CoursePageObject(driver, mywait);
		String parent = driver.getWindowHandle();
		log.info("Capturing the list of Courses");
		List<WebElement> list = hpo.course_list;
		if(list.size()>0) {
			eu.setCellData(rowNum, 0, "Title", 0);
			eu.setCellData(rowNum, 1, "Rating", 0);
			eu.setCellData(rowNum, 2, "Hours", 0);
			rowNum+=1;
			for(int i=0;i<2;i++) {
				hpo.scrollIntoView(list.get(i));
				list.get(i).click();
				Set<String> handles = driver.getWindowHandles();
				for(String str:handles) {
					if(!str.equals(parent)) {
						driver.switchTo().window(str);
						String courseName = cpo.courseText();
						String rating;
						String duration;
						try {
							rating = cpo.ratingText();
							duration = cpo.hoursText();
						}
						catch(Exception e) {
							rating = cpo.optRatingText();
							duration = cpo.optHoursText();
						}
						int hours = cpo.durationInHours(duration);
						System.out.println("Printing the details of course "+(i+1)+":");
						System.out.println("   Title  : "+courseName);
						System.out.println("   Rating : "+rating);
						System.out.println("   Hours  : "+hours);
						eu.setCellData(rowNum, 0, courseName, 1);
						eu.setCellData(rowNum, 1, rating, 1);
						eu.setCellData(rowNum, 2, String.valueOf(hours), 1);
						rowNum+=1;
						driver.close();
					}
					driver.switchTo().window(parent);
				}
				System.out.println();
				list = hpo.course_list;
				driver.switchTo().window(parent);
			}
			rowNum+=1;
			log.info("Captured the first two courses and printed to the console");
			Assert.assertTrue(true);
		}
		else {
			log.error("Unable to capture the list of Courses");
			Assert.fail();
		}
	}
}
