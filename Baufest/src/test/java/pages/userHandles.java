package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class userHandles {
	
	private WebDriver driver;
	
	WebDriverWait wait;
	
	public userHandles(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
		
			
		public void userData(String user, String pass, String linkText, String popup, String fields) throws InterruptedException {
			driver.findElement(By.linkText(linkText)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#"+popup+"Modal>div>div"))); // Espera hasta que el pop up sea visible
			driver.findElement(By.id(fields+"username")).sendKeys(user);
			driver.findElement(By.id(fields+"password")).sendKeys(pass); // Completa los datos requeridos
			driver.findElement(By.xpath("//button[text()='"+linkText+"']")).click();
			Thread.sleep(2000);
	}
		
		public void Logout() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.id("logout2")).click();
			boolean a = driver.findElement(By.linkText("Sign up")).isDisplayed();
			Assert.assertTrue(a);
		}
		
		public void Filter() {
			By laptop = By.xpath("//div[@id='tbodyid']/div[3]/div/div/h4/a");		
			driver.findElement(By.xpath("//a[text()='Laptops']")).click(); //Aplica el filtro de Laptops
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(laptop))); //Espera a que refresque la página
		}
		
		public String selectLaptop(String LaptopName) {
			By laptop = By.xpath("//div[@id='tbodyid']/div[3]/div/div/h4/a");
			By Cart = By.cssSelector("a.btn-success");
			
			LaptopName = driver.findElement(laptop).getText(); //Toma el nombre del producto para luego compararlo
			
			driver.findElement(laptop).click();
			wait.until(ExpectedConditions.elementToBeClickable(Cart));
			driver.findElement(Cart).click(); //Añade al carrito
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return LaptopName;
		}
		
		
		public void Cart() throws InterruptedException {
			driver.findElement(By.id("cartur")).click(); //Abre el carrito
			Thread.sleep(3000);
		}
		
}