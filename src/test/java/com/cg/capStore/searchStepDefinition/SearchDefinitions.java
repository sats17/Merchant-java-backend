package com.cg.capStore.searchStepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchDefinitions {
	private WebDriver driver;
	private WebElement searchBox;
	
	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\harana\\Desktop\\sts-bundle\\BDD Jar Files\\chromedriver_win32\\chromedriver.exe" );
		
		driver= new ChromeDriver();
		
	}
	

	@Given("^user is on 'merchanthome' page$")
	public void user_is_on_merchanthome_page() throws Throwable {
		driver.get("http://localhost:4200/");
		Thread.sleep(1000);
	}
	
	@When("^user searches in inventory$")
	public void user_searches_in_inventory() throws Throwable {
	    searchBox = driver.findElement(By.xpath("/html/body/app-root/html/body/app-merchant/div[1]/input"));
	    searchBox.sendKeys("n");
	}
	
	@Then("^displays 'Empty'$")
	public void displays_Empty() throws Throwable {
		String expectedMessage="Empty";
		String actualMessage=driver.switchTo().alert().getText();
		System.out.println(actualMessage);
		assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
		driver.close();
		driver.quit();
	}
}
