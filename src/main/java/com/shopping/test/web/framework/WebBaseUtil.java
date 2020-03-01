package com.shopping.test.web.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopping.test.web.stepdefs.PlaceOrderStepDefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class WebBaseUtil {

	public static WebDriver driver;
	private static Properties prop;
	private static String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\Config.properties";

	public void ConfigFileReader() {
		prop = new Properties();

		try {
			System.out.println("propertyFile path " + propertyFilePath);
			FileInputStream file = new FileInputStream(propertyFilePath);
			System.out.println("file path " + file);
			prop.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getDriverPath() {

		ConfigFileReader();

		String driverPath = System.getProperty("user.dir") + prop.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Config.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = prop.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		System.out.println("propertyname" + prop.getProperty("applicationurl"));
		String url = prop.getProperty("applicationurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getUsername() {
		String userName = prop.getProperty("username");
		if (userName != null)
			return userName;
		else
			throw new RuntimeException("username not specified in the Configuration.properties file.");
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}

	public void click(WebElement element) {
		element.click();
	}

	public void clearAndFillText(WebElement element, String text) throws Throwable {
		element.clear();
		Thread.sleep(10);
		element.sendKeys(text);
	}

	public Boolean waitUntilElementDisplayed(WebElement element) {
		try {
			(new WebDriverWait(driver, getMaxTimeout())).until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean elementDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static int getMaxTimeout() {
		String config = prop.getProperty("MaxTimeout");

		return (Integer.parseInt(config));

	}

	public void mouseHover(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void hoverAndclick(WebElement Title) throws Throwable {
		Actions action = new Actions(driver);
		action.moveToElement(Title).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class='sfHover']//*[@title='Summer Dresses']")));
		WebElement subMenu = driver.findElement(By.xpath("//*[@class='sfHover']//*[@title='Summer Dresses']"));
		// action.moveToElement(subMenu).perform();
		action.moveToElement(subMenu).click().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void tabHighted(WebElement shippingTab) throws Throwable {

		String color = shippingTab.getCssValue("color");

		String backcolor = shippingTab.getCssValue("background-color");

		System.out.println(color);

		System.out.println(backcolor);

		if (!color.equals(backcolor)) {

			System.out.println("Text is highlighted!");

			Assert.assertNotEquals("ShipingTab is highlighted", color, backcolor);

		}

		else {

			System.out.println("Text is not highlighted!");
		}
	}

	public boolean isSelected(WebElement element) {
		try {
			System.out.println("CheckBox is toggled on ");
			return element.isSelected();

		} catch (Throwable t) {
			System.out.println("CheckBox is toggled off");
			return false;
		}
	}

	// @AfterStep
	// public void tearDown(Scenario scenario) {
	// if (scenario.isFailed()) {
	// // Take a screenshot...
	// final byte[] screenshot = ((TakesScreenshot)
	// driver).getScreenshotAs(OutputType.BYTES);
	// // embed it in the report.
	// scenario.embed(screenshot, "image/png");
	// }
	// }

	// @AfterStep
	// public void tearDown(Scenario scenario) {
	// if (scenario.isFailed()) {
	// // Take a screenshot...
	// final byte[] screenshot = ((TakesScreenshot)
	// driver).getScreenshotAs(OutputType.BYTES);
	// // embed it in the report.
	// scenario.embed(screenshot, "image/png");
	// }
	// }
	//
	//
	// @After
	// public void killBrowser() {
	// driver.close();
	// driver.quit();
	// }

	public void validateProduct(String productA, String productB) throws Throwable {

		// System.out.println(productA.getText());

		// System.out.println(productB.getText());

		// if(productB.contains(product)) {
		//
		// System.out.println("Product Existing on Order History Page!");
		//
		//
		// Assert.assertNotEquals("Product Existing on Order History Page!",
		// productA.getText(), productB.getText());

	}

	// else{
	//
	// System.out.println("Product not Existing on Order History Page!!");
	// }
	// }

}
