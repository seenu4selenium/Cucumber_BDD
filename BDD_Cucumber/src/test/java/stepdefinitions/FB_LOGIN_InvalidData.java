package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.BaseClass;

public class FB_LOGIN_InvalidData extends BaseClass {

	@Given("Open FB URL")
	public void Open_FB_URL() {
		chromeBrowser();
		driver.get("https://www.facebook.com/");		
	}

	@When("User enter invalid credentials")
	public void typeInvalidData() {
		// type UN
		driver.findElement(By.id("email")).sendKeys("hgfuyt7jb8yjhb@gmail.com");
		// type PSWD
		driver.findElement(By.id("pass")).sendKeys("asf23vsd");
	}

	@And("Click on Login button")
	public void clickOnLogin() throws Exception {
		// Click on Login button
		driver.findElement(By.name("login")).click();
		Thread.sleep(8000);
	}

	@Then("Application should display the validation Message")
	public void validationErrorMsg() {
		//if the given locator has present on screen then the size of web element is 1(one) else 0(zero)
		if (driver.findElements(By.xpath("//*[contains(text(),'Find your account and log in.')]")).size() > 0
				|| 
		    driver.findElements(By.xpath("//*[contains(text(),'Create a new Facebook account.')]")).size() > 0) {
			System.out.println("The given credentials are in-valid");
		} else {
			System.out.println("The given credentials are valid");
		}

	}

}
