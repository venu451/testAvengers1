package BasePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.*;

import Utilities.ExcelUtility;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait mywait;
	public static Logger log;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static FileOutputStream fo;
	public static ExcelUtility eu;
	public static int rowNum;
	public static Properties prop;
	
	@BeforeTest
	public static WebDriver driverSetup() throws IOException {
		prop = new Properties();
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		prop.load(file);
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if(prop.getProperty("os").equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}else {
				cap.setPlatform(Platform.MAC);
			}
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
			}
			else {
				cap.setBrowserName("MicrosoftEdge");
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		else {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else {
				driver = new EdgeDriver();
			}
		}
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		eu = new ExcelUtility();
		wb = new XSSFWorkbook();
		ws = wb.createSheet("Sheet1");
		rowNum =0;
		log = LogManager.getLogger();
		fo = new FileOutputStream(System.getProperty("user.dir")+"/exceldata/chrome.xlsx");
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
	}
	
	@AfterTest
	public static void driverClose() throws IOException {
		wb.write(fo);
		wb.close();
		driver.quit();
	}
	
	public static String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;//creating an instance of an TakeScreenshot Interface
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetPath = new File(target);
		src.renameTo(targetPath);
		return target;
	}
}
