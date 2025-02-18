package OpenCartProject;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



import io.cucumber.java.en.*;

public class StepDefination {

	WebDriver driver;


	@Given("opens URL {string}")
	public void opens_url(String url) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}

	@When("Go to register option")
	public void go_to_register_option() {

		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.linkText("Register")).click();

	}
	@Then("Register page should be open")
	public void register_page_should_be_open() {
		Assert.assertTrue(driver.getTitle().contains("Register")); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	//
	//
	//---------To check functionality of Registration with mismatch password--------


	@When("Enter mandetory data with mismatch password")
	public void enter_mandetory_data_with_mismatch_password() {
		driver.findElement(By.name("firstname")).sendKeys("Mahesh");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-email")).sendKeys("vismaya.26@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@12");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("agree")).click();
	}

	@When("Click on Continue with password msg")
	public void click_on_continue_with_password_msg() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), "Password confirmation does not match password!");

	}

	@Then("User Should not register successfully")
	public void user_should_not_register_successfully() {
		Assert.assertTrue(driver.getTitle().contains("Register Account")); 
		driver.quit();
	}


	//----To check functionality of Registration with unchecked privacy policy------


	@When("Enter mandetory data without privacy policy")
	public void enter_mandetory_data_without_privacy_policy() {
		driver.findElement(By.name("firstname")).sendKeys("Mahesh");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-email")).sendKeys("vismaya.6@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}


	@When("Click on Continue with privacy msg")
	public void click_on_continue_with_privacy_msg() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: You must agree to the Privacy Policy!");	
	}


	//---To check functionality of Registration with missing mandetory field---


	@When("Enter data without mandetory field")
	public void enter_data_without_mandetory_field() {
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-email")).sendKeys("vismaya.6@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("agree")).click();

	}

	@When("Click on Continue with error msg")
	public void click_on_continue__with_error_msg() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), "First Name must be between 1 and 32 characters!");

	}


	//-- To check functionality of Registration with already used email--


	@When("Enter data with same email")
	public void enter_data_with_same_email() {
		driver.findElement(By.name("firstname")).sendKeys("Mahesh");
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
		driver.findElement(By.id("input-email")).sendKeys("vismaya.5@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@123");
		driver.findElement(By.name("agree")).click();
	}

	@When("Click on Continue with msg")
	public void click_on_Continue_with_msg() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: E-Mail Address is already registered!");	

	}

	// -------Successfull Register with valid data-------

	@When("Enter mandetory data")
	public void enter_mandetory_data() {
		driver.findElement(By.name("firstname")).sendKeys("Mahesh");
		driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
		driver.findElement(By.id("input-email")).sendKeys("mahajan.20@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@123");
		driver.findElement(By.name("agree")).click();
	}
	@When("Click on Continue")
	public void click_on_continue() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.linkText("Continue")).click();
	}
	@When("User Should register successfully")
	public void user_should_register_successfully() {
		Assert.assertTrue(driver.getTitle().contains("My Account"));

	}
	@Then("User should logout")
	public void user_should_logout() {
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Logout")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Continue")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.quit();
	}


	//Login 


	@When("Go to login option")
	public void go_to_login_option() {
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.linkText("Login")).click();
	}

	@Then("Login page should be open")
	public void login_page_should_be_open() {
		Assert.assertTrue(driver.getTitle().contains("Login")); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}



	//To check login functionality with Invalid data

	@When("Enter email as {string}")
	public void enter_email_as(String email) {
		driver.findElement(By.name("email")).sendKeys(email);


	}

	@When("Enter password as {string}")
	public void enter_password_as(String pws) {
		driver.findElement(By.name("password")).sendKeys(pws);
	}

	@When("Click on Login")
	public void click_on_login() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

	}

	@Then("Login should not be successful")
	public void login_should_not_be_successful() {
		String exp = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals( driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), exp);
		driver.close();
	}

	//check login functionality with valid data

	@When("Enter valid email address and password")
	public void enter_valid_email_address_and_password() {
		driver.findElement(By.name("email")).sendKeys("mahesh1926@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Mahajan@123");
	}



	@Then("Login should be successful")
	public void login_should_be_successful() {
		Assert.assertTrue(driver.getTitle().contains("My Account"));
	}

	@Then("User should be logout")
	public void user_should_be_logout() {
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Logout")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Continue")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.quit();
	}

	// ADD TO CART 

	@When("Click on Desktop")
	public void click_on_desktop() {
		driver.findElement(By.linkText("Desktops")).click();
	}

	@When("Click on mac")
	public void click_on_mac() {
		driver.findElement(By.partialLinkText("Mac")).click();
	}

	@When("Click on imac")
	public void click_on_imac() {
		driver.findElement(By.xpath("//div[@class='product-thumb']")).click();
	}

	@When("Click on Add to Cart")
	public void click_on_add_to_cart() {
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
	}

	@Then("succecc msg will be displayed")
	public void succecc_msg_will_be_displayed() {
		String exp = "Success:";
		if(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains(exp)) {
			System.out.println("Added to cart");
		}

	}

	//Shopping Cart

	//To check availbility of product in shopping cart

	@When("click on shopping cart")
	public void click_on_shopping_cart() {
		driver.findElement(By.linkText("Shopping Cart")).click();
	}

	@When("check the product is same which was added to the cart")
	public void check_the_product_is_same_which_was_added_to_the_cart() {

		driver.findElement(By.xpath("//td[@class='text-left']")).getText().contains("imac");
	}

	@When("Click on Checkout")
	public void click_on_checkout() {
		driver.findElement(By.linkText("Checkout")).click();
	}

	@When("Enter mandetory checkout details")
	public void enter_mandetory_checkout_details() {
		driver.findElement(By.partialLinkText("Billing")).click();
		driver.findElement(By.name("firstname")).sendKeys("Viveka");
		driver.findElement(By.name("lastname")).sendKeys("Bagul");
		driver.findElement(By.name("address_1")).sendKeys("Nashik");
		driver.findElement(By.name("city")).sendKeys("Nashik");
		driver.findElement(By.name("postcode")).sendKeys("12345");
		WebElement cnt = driver.findElement(By.name("country_id"));
		Select country = new Select(cnt);
		country.selectByVisibleText("India");
		WebElement zone = driver.findElement(By.name("zone_id"));
		Select state = new Select(zone);
		state.selectByVisibleText("Maharashtra");


	}

	@When("Enter shipping details")
	public void enter_shipping_details() {
		driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();
		driver.findElement(By.xpath("//input[@name='shipping_address']")).isSelected();
		driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();
		driver.findElement(By.xpath("//input[@name='shipping_address']")).click();
		driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();
		driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
	}

	@When("Enter Payment details")
	public void enter_payment_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
	}

	@When("Click on Confirm Order")
	public void click_on_confirm_order() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='button-confirm']")).click();
	}

	@Then("Order Confirmation msg")
	public void order_confirmation_msg() {
		String expT = "Your order has been placed!";
		if(driver.getTitle().equalsIgnoreCase(expT)){
			driver.findElement(By.linkText("Continue")).click();

		}

	}







}
