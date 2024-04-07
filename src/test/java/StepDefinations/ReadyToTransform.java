package StepDefinations;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.ReadytotransformObject;
import PageObjects.RegisterForm;

public class ReadyToTransform extends BaseClass {
	ReadytotransformObject ro;
	RegisterForm Rf;
	
	@Given("the user is on the home page of coursera")
	public void the_user_is_on_the_home_page_of_coursera() throws InterruptedException {
		ro=new ReadytotransformObject(driver,mywait);
		ro.ForIndividualsClick();
		ro.scrolldown();
	}

	@When("the user enters click on the For Enterprise")
	public void the_user_enters_click_on_the_for_enterprise() {
		ro.ForEnterprise();
	}

	@When("the user enters into that For Enterprise page and click on the Solutions")
	public void the_user_enters_into_that_for_enterprise_page_and_click_on_the_solutions() {
		ro.SolutionClick();
	}

	@When("the user enters into the Solutions and navigate to Coursera for Campus section")
	public void the_user_enters_into_the_solutions_and_navigate_to_coursera_for_campus_section() {
		ro.Courses();

	}

	@Then("the user should be redirected to the Registration form  page")
	public void the_user_should_be_redirected_to_the_registration_form_page() {
		ro.Contactclick();
	}

	@Then("fill the FirstName and LastName and Email and Passwrod")
	public void fill_the_first_name_and_last_name_and_email_and_passwrod() {
		Rf=new RegisterForm(driver,mywait);
		Rf.FirstName();
		Rf.LatName();
		Rf.email();
		Rf.PhoneNo();
		
        
	}

	@Then("click on the submit button")
	public void click_on_the_submit_button() {
		Rf.Submitbutton();
	}

	@Then("the user should see a Error message")
	public void the_user_should_see_a_error_message() throws IOException {
		WebElement mess=driver.findElement(By.xpath("//div[@class=\"mktoError\"]"));
		String message = mess.getText();
		System.out.println("Error Message : ");
		eu.setCellData(rowNum, 0, "Error Message", 0);
		rowNum+=1;
		eu.setCellData(rowNum, 0, message, 1);
		rowNum+=1;
		System.out.println(message);
		Rf.screenshot1();
	}
}
