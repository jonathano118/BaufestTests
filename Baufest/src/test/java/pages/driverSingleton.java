package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverSingleton {

	private static driverSingleton driverS = new driverSingleton();
	
	public WebDriver driver;
	
	
	private driverSingleton() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static driverSingleton getDriver() {
		if(driverS == null){
            driverS = new driverSingleton();
        }

        return driverS;
	}
}
	
