package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

public class Hooks extends BaseClass{

	@Before
	public void beforeTestCaseRun() throws Exception {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata/td.properties");
		prop.load(fi);
	}
	@After
	public void afterTestCaseRun() throws Exception {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMyyyy_HH_mm_ss");
		String timeStamp = df.format(d);
		
		FileInputStream screenshotPath = new FileInputStream("C:\\Users\\nalla\\eclipse-workspace\\BDD_Cucumber\\src\\test\\resources\\screenshots\\");
		//Take a current screenshot, then stored it into RAM location
		 File abc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //Move this file to your location
		 FileHandler.copy(abc, new File(screenshotPath+"Test"+timeStamp+".PNG"));
	}
}
