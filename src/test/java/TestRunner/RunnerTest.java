package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
				features= {".//FeatureFiles/CourseInfo.feature"},
				glue="StepDefinations",
				plugin= {"pretty","html:Reports/myreports.html",
						 "rerun:target/rerun.txt",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
				
				
				dryRun=false,
				monochrome=true, 
				publish=true 
			)
	
	public class RunnerTest{
		
	}
