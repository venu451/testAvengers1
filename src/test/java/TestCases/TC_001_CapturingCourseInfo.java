package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClassNG;
import PageObjects.CoursePageObject;
import PageObjects.HomePageObject;

public class TC_001_CapturingCourseInfo extends BaseClassNG {
	
	HomePageObject hpo;
	CoursePageObject cpo;
	
	@Test(priority=0)
	public void courseSearch() {
//		JavascriptExecutor js = (JavascriptExecutor)(driver);
		hpo = new HomePageObject(driver,mywait);
		log.info("The user sends the input as Web development Courses as input to search Box");
		hpo.sendData("Web Development");
		hpo.searchClick();
		log.info("The user clicks on the search button");
		hpo.clickLang();
		log.info("The user selected the language as English");
		hpo.clickLevel();
		log.info("The user selected the level as Beginner");
		try {
			hpo.filterSelectionStatus();
			log.info("The status of the filters is applied");
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			log.info("The filter status is not updated");
			Assert.fail(); 
		}
	}
	
	@Test(priority=1,dependsOnMethods = {"courseSearch"})
	public void capturingCourseData() throws IOException {
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
