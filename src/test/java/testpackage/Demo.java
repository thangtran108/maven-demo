package testpackage;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.helpers.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

public class Demo {
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/";
	public String adminpage = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
	String driverPatch = "C://chromedriver-win64//chromedriver.exe";
	public WebDriver driver;

	@Test
	public void demo() {
		// set the system property for Chrome driver
		System.setProperty(driverPatch, baseUrl);

		// Create driver object for CHROME browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);

		// input username and password
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		// click to login
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// get the account after login of the page
		WebElement element = driver.findElement(By.tagName("p"));
		String account = element.getText();
		System.out.println("Account: " + account);

		// Navigate to Admin page
		driver.navigate().to(adminpage);
	}

}