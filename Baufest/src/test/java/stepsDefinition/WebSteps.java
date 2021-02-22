package stepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.userSingleton;
import pages.driverSingleton;
import pages.userHandles;

public class WebSteps {
	
	
	private userSingleton userC = userSingleton.getUser(); 
	private driverSingleton driverS = driverSingleton.getDriver();
	
	WebDriver driver = driverS.driver;
	
	private userHandles userHandles = new userHandles(driver);
	
	private String URL = "https://www.demoblaze.com/index.html";
	private String laptop;
		
	
	//Sign up
	@Given("^a new user opening the webpage$")
	public void a_new_user_opening_the_webpage() throws Throwable {
		driver.get(URL);
	}
	

	@When("^I try to register with a username and a password$")
	public void i_try_to_register_with_a_username_and_a_password() throws Throwable {
		userHandles.userData(userC.username, userC.passw, "Sign up", "signIn", "sign-");
	}

	
	@Then("^I should succesfully signup$")
	public void i_should_succesfully_signup() throws Throwable {

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Sign up successful.");
		alert.accept();
	}

	
	
	//Log in
	@Given("^a registered user that is not logged in$") 
	 public void a_registered_user_that_is_not_logged_in() {
		Assert.assertTrue(driver.findElement(By.id("login2")).isDisplayed());
	 }
	 
	
	@When("^I enter the username and a password$")
	public void I_enter_the_username_and_password() throws InterruptedException{
		userHandles.userData(userC.username, userC.passw, "Log in", "logIn", "login");
	}
	
	
	@Then("^I should be able to log in$") 
	public void I_should_be_able_to_log_in() {
		WebElement name = driver.findElement(By.id("nameofuser"));
		Assert.assertEquals(name.getText(), "Welcome " + userC.username); //Comprueba que el usuario ingresó con éxito
	}
	
	

	//Add an item to the cart
	@Given("^a registered user searching for laptops$")
	public void a_registered_user_searching_for_laptops() {
		
		userHandles.Filter();
		
	}
	
	@When ("^I add a new one to the cart$")
	public void I_add_a_new_one_to_the_cart() {
		
		laptop = userHandles.selectLaptop(laptop);
	}
	
	@Then ("^I should see it on the cart page$")
	public void I_should_see_it_on_the_cart_page() throws InterruptedException {
		
		userHandles.Cart();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]")).getText(), laptop); //Compara el nombre del artículo en el carrito con el escogido
	}
	
	
	//Log out
	@Given ("^a logged in user$")
	public void a_logged_in_user() {
		Assert.assertTrue(driver.findElement(By.id("logout2")).isDisplayed());
	}
	
	
	@When ("^I click on log out button$")
	public void I_click_on_log_out_button() {
		
		driver.findElement(By.id("logout2")).click();
	}
	
	
	@Then ("^I should succesfully log out from page$")
	public void I_should_succesfully_log_out_from_page() {
		userHandles.LogoutCheck();
		driver.close();
	}
	
	
}
