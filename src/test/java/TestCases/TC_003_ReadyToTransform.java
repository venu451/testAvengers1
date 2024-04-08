package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import BasePackage.BaseClassNG;
import PageObjects.ReadytotransformObject;
import PageObjects.RegisterForm;
import Utilities.DataReader;

public class TC_003_ReadyToTransform extends BaseClassNG{
	ReadytotransformObject ro;
	RegisterForm Rf;
	List<HashMap<String, String>> datamap;
	
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
	
	public void fillingTheForm() throws IOException, InterruptedException {
		Rf=new RegisterForm(driver,mywait);
		log.info("User navigated to ready to transform page");
		log.info("user entered all the detailed");
//		Rf.FirstName();
//		Rf.LatName();
//		Rf.email();
//		Rf.PhoneNo();
//		Rf.Submitbutton();
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\readyToTransform.xlsx", "Sheet1");

        for(int row=1;row<=3;row++) {
        	int index=row-1;
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
    		Rf.Submitbutton();
//    		log.info("User captured the error message");
//    		String ErrorMess=Rf.Error();
//    		System.out.printf("ERROR MESSAGE:");
//    		eu.setCellData(rowNum, 0, "Error Message", 0);
//    		rowNum+=1;
//    		eu.setCellData(rowNum, 0, ErrorMess, 1);
//    		rowNum+=1;
//    		System.out.println(ErrorMess);
//    		Rf.screenshot1();
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
		
//		log.info("User captured the error message");
//		String ErrorMess=Rf.Error();
//		System.out.printf("ERROR MESSAGE:");
//		eu.setCellData(rowNum, 0, "Error Message", 0);
//		rowNum+=1;
//		eu.setCellData(rowNum, 0, ErrorMess, 1);
//		rowNum+=1;
//		System.out.println(ErrorMess);
//		Rf.screenshot1();
	}
}
