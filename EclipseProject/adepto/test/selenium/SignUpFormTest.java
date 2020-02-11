package com.adepto.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpFormTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		
		driver.get("https://smoketesteu.adepto.com/portal/signup");
		driver.manage().window().maximize();
	}
	
	@Test
	public void signUpProcessTest() throws InterruptedException {
		//find and enter email
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys("gneelima12@maildrop.cc");
		
		//enter first name
		WebElement firstNameElement = driver.findElement(By.id("firstName"));
		firstNameElement.sendKeys("Neelima");
		
		//enter last name
		WebElement lastNameElement = driver.findElement(By.id("lastName"));
		lastNameElement.sendKeys("G");
		
		//enter password
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys("ad*pt01");
		
		//click signupbutton
		WebElement signUpButton = driver.findElement(By.className("ikYlmz")).findElement(By.className("MuiButton-root"));
		signUpButton.click();
		
		//check the checkbox - accept terms
		WebElement acceptCheckBox = driver.findElement(By.className("dNUYZM")).findElement(By.tagName("input"));
		acceptCheckBox.click();
		
		//click continue button
		WebElement continueButton = driver.findElement(By.className("haqMei")).findElement(By.linkText("CONTINUE"));
		continueButton.click();
		
		Thread.sleep(10000);
		//at CV upload page - just click next without uploading cv
		clickNext();
		
		//at Experience page
		clickNext();
		
		//at personalise page - enter phone number and click next
		WebElement phoneElement = driver.findElement(By.id("phoneNumbers-phone"));
		phoneElement.sendKeys("4234");
		
		clickNext();
	
		//at work preferences page
		clickNext();
		
		//at finalpage click complete button
		WebElement completeButton = driver.findElement(By.className("buttons_container")).findElement(By.linkText("Complete"));
		completeButton.click();
		
	}
	
	@Test
	public void loginPageFromSignUpPageTest() {
		WebElement toLoginPageEle = driver.findElement(By.linkText("I already have an account"));
		toLoginPageEle.click();
		
		WebElement emailElement = driver.findElement(By.id("username"));
		emailElement.sendKeys("gneelima123@maildrop.cc");
		
		WebElement firstNameElement = driver.findElement(By.id("password"));
		firstNameElement.sendKeys("ad*pt01");
		
		WebElement loginButton = driver.findElement(By.className("ktGnys")).findElement(By.className("MuiButton-root"));
		loginButton.click();
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	private void clickNext() {
		WebElement nextButton = driver.findElement(By.className("gCzogm")).findElement(By.linkText("Next"));
		nextButton.click();
	}
}
