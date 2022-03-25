package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import utilities.BaseClass;

public class FB_Login extends BaseClass{
	
	@When("User enter valid credentials")
	public void typeInvalidData() {
		// type UN
		driver.findElement(By.id("email")).sendKeys("h2otestingtools@gmail.com");
		// type PSWD
		driver.findElement(By.id("pass")).sendKeys("Testing@123");
	}
}
