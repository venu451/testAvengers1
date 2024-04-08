package StepDefinations;



import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.ReadytotransformObject;
import PageObjects.RegisterForm;
import Utilities.DataReader;

public class ReadyToTransform extends BaseClass {
	ReadytotransformObject ro;
	RegisterForm Rf;
	List<HashMap<String, String>> datamap;
	
	@Given("the user is on the home page of coursera")
	public void the_user_is_on_the_home_page_of_coursera() throws InterruptedException {
		ro=new ReadytotransformObject(driver,mywait);
		ro.ForIndividualsClick();
		log.info("user scrolling the page to the bottom");
		ro.scrolldown();
	}

	@When("the user enters click on the For Enterprise")
	public void the_user_enters_click_on_the_for_enterprise() {
		ro.ForEnterprise();
		log.info("User clicked on ForEnterprise");
	}

	@When("the user enters into that For Enterprise page and click on the Solutions")
	public void the_user_enters_into_that_for_enterprise_page_and_click_on_the_solutions() {
		ro.SolutionClick();
		log.info("Users clicks on the solutions");
	}

	@When("the user enters into the Solutions and navigate to Coursera for Campus section")
	public void the_user_enters_into_the_solutions_and_navigate_to_coursera_for_campus_section() {
		ro.Courses();

	}

	@Then("the user should be redirected to the Registration form  page")
	public void the_user_should_be_redirected_to_the_registration_form_page() {
		ro.Contactclick();
		log.info("users clicks on the ready to transform");
	}

	@Then("fill the FirstName and LastName and Email and Password as by passing  {string}")
	public void fill_the_first_name_and_last_name_and_email_and_password_as_by_passing(String rows) {
		log.info("User navigated to ready to transform page");
		log.info("user entered all the detailed");
		Rf=new RegisterForm(driver,mywait);
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\readyToTransform.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String firstname= datamap.get(index).get("firstname");
        String lastname= datamap.get(index).get("lastname");
        String email= datamap.get(index).get("email");
        String pass = datamap.get(index).get("password");
        String inst = datamap.get(index).get("institution");
		Rf.FirstName(firstname);
		Rf.LatName(lastname);
		Rf.email(email);
		Rf.PhoneNo(pass);
		Rf.Institution(inst);
	}

	@Then("click on the submit button")
	public void click_on_the_submit_button() {
		Rf.Submitbutton();
	}

	@Then("the user should see a Error message")
	public void the_user_should_see_a_error_message() throws IOException {
		log.info("User captured the error message");
		String message = ro.mess.getText();
		message = ro.relLabel.getText()+": "+message;
		System.out.println("Error Message : ");
		eu.setCellData(rowNum, 0, "Error Message", 0);
		rowNum+=1;
		eu.setCellData(rowNum, 0, message, 1);
		rowNum+=2;
		System.out.println(message);
		Rf.screenshot1(ro.relLabel.getText());
	}
}
