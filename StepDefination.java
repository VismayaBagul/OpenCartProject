package Registration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
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
		
	
	}
	
	
	// -------Successfull Register with valid data-------
	
	@When("Enter mandetory data")
	public void enter_mandetory_data() {
	 driver.findElement(By.name("firstname")).sendKeys("Mahesh");
	 driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
	 driver.findElement(By.id("input-email")).sendKeys("vismaya.20@gmail.com");
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
	@Then("User Should register successfully")
	public void user_should_register_successfully() {
	   Assert.assertTrue(driver.getTitle().contains("My Account"));
	   driver.quit();
	}
	
	//---------To check functionality of Registration with mismatch password--------

	
//	@When("Enter mandetory data with mismatch password")
//	public void enter_mandetory_data_with_mismatch_password() {
//	 driver.findElement(By.name("firstname")).sendKeys("Mahesh");
//	 driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
//	 driver.findElement(By.id("input-email")).sendKeys("vismaya.202026@gmail.com");
//	 driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
//	 driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
//	 driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@12");
//	 driver.findElement(By.name("agree")).click();
//	}
//	
//	@When("Click on Continue with password msg")
//	public void click_on_continue_with_password_msg() {
//		 driver.findElement(By.xpath("//input[@type='submit']")).click();
//		 Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']")).getText(), "Password confirmation does not match password!");
//		
//	}
//	
//	@Then("User Should not register successfully")
//	public void user_should_not_register_successfully() {
//	   Assert.assertTrue(driver.getTitle().contains("Rgister Account")); 
//	   driver.quit();
//	}
//	@When("Enter mandetory data without privacy policy")
//	public void enter_mandetory_data_without_privacy_policy() {
//	 driver.findElement(By.name("firstname")).sendKeys("Mahesh");
//	 driver.findElement(By.id("input-lastname")).sendKeys("Mahajan");
//	 driver.findElement(By.id("input-email")).sendKeys("vismaya.202026@gmail.com");
//	 driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
//	 driver.findElement(By.id("input-password")).sendKeys("Mahesh@123");
//	 driver.findElement(By.id("input-confirm")).sendKeys("Mahesh@123");
//	
//	}
	
	
	

//	
//	@When("Click on Continue with privacy msg")
//	public void click_on_continue_with_privacy_msg() {
//		 driver.findElement(By.xpath("//input[@type='submit']")).click();
//		 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: You must agree to the Privacy Policy!");
//		 driver.quit();
//	}
//	
//	
//	@When("Click on Continue with error msg")
//	public void click_on_continue__with_error_msg() {
//		 driver.findElement(By.xpath("//input[@type='submit']")).click();
//		 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), "First Name must be between 1 and 32 characters!");
//		 driver.quit();
//	}
	
	
	
	
	
	
	
}
