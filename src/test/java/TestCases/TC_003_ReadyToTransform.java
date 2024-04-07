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
		ro.scrolldown();
		ro.ForEnterprise();
		ro.SolutionClick();
		ro.Courses();
		ro.Contactclick();
}

	@Test(priority=2)
	
	public void fillingTheForm() throws IOException {
		Rf=new RegisterForm(driver,mywait);
		Rf.FirstName();
		Rf.LatName();
		Rf.email();
		Rf.PhoneNo();
		Rf.Submitbutton();
		
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
