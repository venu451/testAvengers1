package TestCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageObjects.CoursePageObject;
import PageObjects.HomePageObject;

public class TC_001_CapturingCourseInfo extends BaseClass {
	
	HomePageObject hpo;
	CoursePageObject cpo;
	
	@Test(priority=0)
	public void courseSearch() {
//		JavascriptExecutor js = (JavascriptExecutor)(driver);
		hpo = new HomePageObject(driver,mywait);
		hpo.sendData("Web Development");
		hpo.searchClick();
		hpo.clickLang();
		hpo.clickLevel();
		try {
			hpo.filterSelectionStatus();
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			Assert.fail(); 
		}
	}
	
	@Test(priority=1,dependsOnMethods = {"courseSearch"})
	public void capturingCourseData() {
		cpo = new CoursePageObject(driver, mywait);
		String parent = driver.getWindowHandle();
		List<WebElement> list = hpo.course_list;
		if(list.size()>0) {
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
						driver.close();
					}
					driver.switchTo().window(parent);
				}
				System.out.println();
				list = hpo.course_list;
				driver.switchTo().window(parent);
				Assert.assertTrue(true);
			}
		}
		else {
			Assert.fail();
		}
	}
}
