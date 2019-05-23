package Implicit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart{

	WebDriver driver; 
	String username = "bbks101@gmail.com"; // Change to your username and passwrod
	String password = "bbks101@PT";
	//WebDriverWait wait=new WebDriverWait(driver, 20);
	// This method is to navigate flipkart URL
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver","F:\\Testing\\selenium\\jarfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");
	}
	@BeforeMethod
	public void explixit(){
		//WebDriverWait wait=new WebDriverWait(driver, 20);
	}

	
	// To log in flipkart
	@Test(priority=1)
	public void login() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement id;
		id=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='_2zrpKA']")));
	    id.sendKeys(username);
		WebElement pass;
		pass=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='_2zrpKA _3v41xv']")));
		pass.sendKeys(password);
		WebElement login;
		login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")));
		login.click();
	}

	// Search For product
	@Test(priority=2)
	public void searchAndSelect(){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement search;
		search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='q']")));
		search.sendKeys("televisions");
		WebElement clicksearch;
		clicksearch=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='vh79eN']")));
		clicksearch.click();
		WebElement clickurl;
		clickurl=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_3wU53n']")));
		clickurl.click();
		
	}

	@Test(priority=3)
	public void buyAndRemoveFromCart() {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		WebElement addToCart;
		addToCart=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("_2AkmmA._2Npkh4._2kuvG8._7UHT_c")));
		addToCart.click();
		
	}

	//@Test(priority=4)
	//public void logout() {
		//WebElement cursormove = driver.findElement(By.xpath("//div[@class='_2aUbKa']"));
		//Actions s = new Actions(driver);
		//s.moveToElement(cursormove).build().perform();
		//driver.findElement(By.linkText("Logout")).click();
	//}

	@AfterClass
	public void quit() {
		driver.close();
	}
}
