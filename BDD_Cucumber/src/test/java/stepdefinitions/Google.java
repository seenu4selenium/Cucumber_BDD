package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.BaseClass;

public class Google extends BaseClass{

	@Given("Open Google webpage")
	public void Open_FB_URL() {
		chromeBrowser();
		driver.get("https://www.google.com/");
	}

	@Then("Search with Selenium Text")
	public void searchText() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@And("Choose Selenium website")
	public void chooseSeleniumWebsite() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/div/cite")).click();
		Thread.sleep(2000);
	}

	@Then("Verify the title continas Selenium")
	public void titleValidation() {
		String tileofThePage = driver.getTitle();
		if (tileofThePage.contains("Selenium")) {
			System.out.println("Selenium Title has displayed as expected");
		} else {
			System.out.println("Selenium Title is not displayed");

		}
	}

}
