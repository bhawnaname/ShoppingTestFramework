package com.shopping.test.web.stepdefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopping.test.web.framework.WebBaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class PlaceOrderStepDefs {
	WebBaseUtil webBaseUtil = new WebBaseUtil();
	WebDriver driver;
	static String product = "Faded Short Sleeve T-shirts";

	@Given("I navigate to application")
	public void i_navigate_to_application() throws Throwable {

		System.setProperty("webdriver.chrome.driver", webBaseUtil.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(webBaseUtil.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(webBaseUtil.getApplicationUrl());

	}

	@Given("I logged in as as registered user")
	public void i_logged_in_as_as_registered_user() throws Throwable {

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

	@Given("I navigate to the Dress ProductListing Page")
	public void i_navigate_to_the_Dress_ProductListing_Page() throws Throwable {
		WebElement Title = driver.findElement(By.className("sf-with-ul"));
		Actions action = new Actions(driver);
		action.moveToElement(Title).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='sfHover']//*[@title='T-shirts']")));
		WebElement subMenu = driver.findElement(By.xpath("//*[@class='sfHover']//*[@title='T-shirts']"));
		action.moveToElement(subMenu).click().perform();

	}

	@When("I add Tshirt item to my basket")
	public void i_add_Tshirt_item_to_my_basket() throws Throwable {

		WebElement mouseHover = driver.findElement(By.className("product_img_link"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default']")));
		WebElement subMenu = driver
				.findElement(By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default']"));
		action.moveToElement(subMenu).click().perform();

		// WebElement addButton =
		// driver.findElement(By.xpath("//*[@class='button
		// ajax_add_to_cart_button btn btn-default']"));
		// webBaseUtil.click(addButton);

	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() throws Throwable {
		WebElement checkoutButton = driver.findElement(By.xpath("//*[@class='btn btn-default button button-medium']"));
		webBaseUtil.click(checkoutButton);
		WebElement checkout = driver.findElement(By.xpath("//*[@class='cart_navigation clearfix']//a"));
		webBaseUtil.click(checkout);

	}

	@When("I am on the Shipping details")
	public void i_am_on_the_Shipping_details() throws Throwable {
		WebElement addressCheckout = driver
				.findElement(By.xpath("//*[@class='cart_navigation clearfix']//button[@name='processAddress']"));
		webBaseUtil.click(addressCheckout);
		// WebElement shippingTab =
		// driver.findElement(By.xpath("//div[@id='carrier_area']//ul[@id='order_step']//li[4])"));
		// webBaseUtil.tabHighted(shippingTab);

	}

	@When("I agree to the Terms and Conditions on shipping details")
	public void i_agree_the_the_Terms_and_Conditions_on_shipping_details() throws Throwable {

		WebElement checkBox = driver.findElement(By.xpath("//*[@class='checkbox']//div//span"));
		checkBox.click();
		webBaseUtil.isSelected(checkBox);
		WebElement shippingCheckout = driver.findElement(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']"));
		webBaseUtil.click(shippingCheckout);
	}

	@When("I am on the payment details")
	public void i_am_on_the_payment_details() throws Throwable {
		WebElement PaymentTab = driver.findElement(By.xpath("//*[@class='step_current last']"));
		webBaseUtil.tabHighted(PaymentTab);
		WebElement productName = driver.findElement(By.xpath("//*[@class='cart_description']//p[@class='product-name']/a"));
		String ProductDescriptionAdded = productName.getText();
		product = ProductDescriptionAdded;
		System.out.println("ProductDescription on Cart page" + ProductDescriptionAdded);
		WebElement paymentModule = driver.findElement(By.xpath("//*[@class='payment_module'][1]"));
		webBaseUtil.click(paymentModule);
	}

	@When("I confirm my order on payment page")
	public void i_confirm_my_order_on_payment_page() throws Throwable {
		WebElement confirmOrder = driver.findElement(By.xpath("//*[@class='button btn btn-default button-medium']"));
		webBaseUtil.click(confirmOrder);
	}

	@Then("I  navigate to the order confirmation page")
	public void i_navigate_to_the_order_confirmation_page() throws Throwable {
		WebElement orderConfirmation = driver.findElement(By.xpath("//*[@id='order-confirmation']//h1"));
		Boolean elementVisible = webBaseUtil.elementDisplayed(orderConfirmation);
		Assert.assertTrue("Order Confirmation Page displayed successfully", elementVisible);
		driver.close();

	}



	@Given("I navigate to Order History page")
	public void i_navigate_to_Order_History_page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", webBaseUtil.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(webBaseUtil.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php?controller=history");
		WebElement SignIn = driver.findElement(By.className("login"));
		webBaseUtil.click(SignIn);
		WebElement Email = driver.findElement(By.id("email"));
		webBaseUtil.waitUntilElementDisplayed(Email);

		WebElement Password = driver.findElement(By.id("passwd"));
		webBaseUtil.clearAndFillText(Email, webBaseUtil.getUsername());
		webBaseUtil.clearAndFillText(Password, webBaseUtil.getPassword());
		WebElement Signin = driver.findElement(By.id("SubmitLogin"));
		webBaseUtil.click(Signin);
		WebElement orderHistoryTab = driver.findElement(By.xpath("//*[@class='myaccount-link-list']//a[1]"));
		webBaseUtil.click(orderHistoryTab);

		// WebElement backOrder =
		// driver.findElement(By.xpath("//*[@class='history_detail
		// footable-last-column']/a"));
		// webBaseUtil.click(backOrder);

	}

	@Then("I should see the OrderDetails on the OrderHistoryPage")
	public void i_should_see_the_OrderDetails_on_the_OrderHistoryPage() throws Throwable {

		List<WebElement> orderDetail = driver.findElements(By.xpath(
				"//*[@id='block-history']//table//td[@class='history_detail footable-last-column']//a[@class='btn btn-default button button-small']"));
		for (int i = 0; i < orderDetail.size(); i++) {
			orderDetail.get(i).click();
			WebElement productElement = driver
					.findElement(By.xpath("//*[@id='order-detail-content']//td[@class='bold']//label"));
			String productB = productElement.getText();
			System.out.println("product added in history" + productB);
			System.out.println("product added " + product);
			if (productB.contains(product)) {
				System.out.println("Product Existing on Order History Page!");
				break;
			} else
				continue;

		}
		driver.close();

	}

	// @After
	// public void killBrowser() {
	// driver.close();
	//
	// }

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

}
