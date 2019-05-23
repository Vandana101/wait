package Implicit;

import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazon {
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","F:\\Testing\\selenium\\jarfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com/");
	}

	@BeforeMethod
	public void printOpen() {
		System.out.println("open");
	}

	@Test(priority = 1)
	public void signInAccount() {
		driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(
				"vandanaboora234@gmail.com");
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(
				"boora@123");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}

	@Test(priority = 2)
	public void searchAndSelect() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
				.sendKeys("oneplus6 phone");
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		// driver.findElement(By.xpath("//img[@class='s-image']"))
		driver.findElement(
				By.xpath("//div[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[4]/div/div/div/div[2]/div[2]/div/div/div/div/div/h2/a"))
				.click();
	}

	@Test(priority = 3)
	public void addToCart() {
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']"))
				.click();
	}

	@Test(priority = 4)
	public void logout() {
		WebElement cursormove = driver
				.findElement(By
						.xpath("//a[@id='nav-link-accountList']"));
		Actions mouseactions = new Actions(driver);
		mouseactions.moveToElement(cursormove).build().perform();
		driver.findElement(By.xpath("//span[@class='nav-text' and contains(text(),\"Sign Out\")]")).click();
	}
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
}
