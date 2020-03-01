package com.shopping.test.web.stepdefs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.shopping.test.web.framework.WebBaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class personalInfoStepDefs {
	WebBaseUtil webBaseUtil = new WebBaseUtil();
	WebDriver driver;

	@Given("I login to the application as signed in user")
	public void i_login_to_the_application_as_signed_in_user() throws Throwable {

		System.setProperty("webdriver.chrome.driver", webBaseUtil.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(webBaseUtil.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(webBaseUtil.getApplicationUrl());

		WebElement SignIn = driver.findElement(By.className("login"));
		webBaseUtil.click(SignIn);
		WebElement Email = driver.findElement(By.id("email"));
		webBaseUtil.waitUntilElementDisplayed(Email);

		WebElement Password = driver.findElement(By.id("passwd"));
		webBaseUtil.clearAndFillText(Email, webBaseUtil.getUsername());
		webBaseUtil.clearAndFillText(Password, webBaseUtil.getPassword());
		WebElement Signin = driver.findElement(By.id("SubmitLogin"));
		webBaseUtil.click(Signin);

	}

	@Given("I view the My Account Page")
	public void i_view_the_My_Account_Page() throws Throwable {
		WebElement myPersonalInfo = driver.findElement(By.xpath("//*[@class='page-heading']"));
		String getName = myPersonalInfo.getText();
		System.out.println(getName + "getName");
		String myAccount = "MY ACCOUNT";

		Assert.assertEquals("My Account displaying", myAccount, getName);

	}

	@Given("I view the My Personal Information")
	public void i_view_the_My_Personal_Information() throws Throwable {
		WebElement myPersonalInfo = driver.findElement(By.xpath("//*[@class='myaccount-link-list']//li[4]//span"));
		webBaseUtil.click(myPersonalInfo);

	}

	@When("I update the {string} in {string}")
	public void i_update_the_in(String Name, String Element) throws Throwable {

		WebElement NameField = driver.findElement(By.id("firstname"));

		webBaseUtil.clearAndFillText(NameField, Name);

	}

	@When("I enter {string} in {string}")
	public void i_enter_in(String Password, String Element) throws Throwable {
		WebElement PasswordField = driver.findElement(By.id("old_passwd"));

		webBaseUtil.clearAndFillText(PasswordField, webBaseUtil.getPassword());

	}

	@When("I click on save")
	public void i_click_on_save() {
		WebElement saveButton = driver.findElement(By.xpath("//*[@class='form-group']//button"));
		webBaseUtil.click(saveButton);

	}

	@Then("I should see the successful update personal Information message")
	public void i_should_see_the_successful_update_personal_Information_message() throws Throwable {
		WebElement alertPopup = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
		String expectedMessage = "Your personal information has been successfully updated";
		String alert = alertPopup.getText().trim();
		System.out.println(alert + ": alert");
		if (alert.contains(expectedMessage)) {
			Assert.assertTrue("Your personal information has been successfully updated", true);

		} else {
			Assert.assertTrue("Your personal information has not  been successfully updated", false);
		}

	}

	@Then("I should see the updated {string} on My Account Header")
	public void i_should_see_the_updated_on_My_Account_Header(String Name) {
		WebElement headerName = driver.findElement(By.xpath("//*[@class='header_user_info']//span"));
		System.out.println(Name + "Name");
		if (headerName.getText().contains(Name)) {
			Assert.assertTrue("Name is displaying as Updated : Name", true);
			driver.close();

		}

		Assert.assertFalse("Name is not displaying as Updated : Name", false);

	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed it in the report.
			scenario.embed(screenshot, "image/png");
			driver.close();

		}

	}

	public void screenShot() throws IOException, InterruptedException {
		// File scr = ((TakesScreenshot) driver
		// ).getScreenshotAs(OutputType.FILE);
		// String filename = new
		// SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
		// //File dest = new
		// File("C:\\Users\\bhavohra\\workspace\\shopping-test-automation\\target\\ScreenShotCaptured"
		// + filename);
		// FileUtils.copyFile(scr, dest);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File(
				"C:\\Users\\bhavohra\\workspace\\shopping-test-automation\\target\\ScreenShotCaptured\\screenshot_"
						+ timestamp() + ".png");
		FileUtils.copyFile(scr, dest);
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
