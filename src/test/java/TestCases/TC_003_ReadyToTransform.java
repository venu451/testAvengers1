package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageObjects.ReadytotransformObject;
import PageObjects.RegisterForm;

public class TC_003_ReadyToTransform extends BaseClass{
	ReadytotransformObject ro;
	RegisterForm Rf;
	
	@Test(priority=1)
	public void navigationToContactUsPage() throws InterruptedException{
		ro=new ReadytotransformObject(driver,mywait);
		ro.ForIndividualsClick();
		log.info("user scrolling the page to the bottom");
		ro.scrolldown();
		ro.ForEnterprise();
		log.info("User clicked on ForEnterprise");
		ro.SolutionClick();
		log.info("Users clicks on the solutions");
		ro.Courses();
		ro.Contactclick();
		log.info("users clicks on the ready to transform");
}

	@Test(priority=2)
	
	public void fillingTheForm() throws IOException {
		Rf=new RegisterForm(driver,mywait);
		log.info("User navigated to ready to transform page");
		log.info("user entered all the detailed");
		Rf.FirstName();
		Rf.LatName();
		Rf.email();
		Rf.PhoneNo();
		Rf.Submitbutton();
		
		log.info("User captured the error message");
		String ErrorMess=Rf.Error();
		System.out.printf("ERROR MESSAGE:");
		eu.setCellData(rowNum, 0, "Error Message", 0);
		rowNum+=1;
		eu.setCellData(rowNum, 0, ErrorMess, 1);
		rowNum+=1;
		System.out.println(ErrorMess);
		Rf.screenshot1();
	}
}
