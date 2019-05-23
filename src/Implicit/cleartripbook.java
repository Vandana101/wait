package Implicit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cleartripbook {
WebDriver driver;
@BeforeClass
public void intializeDriver(){
	driver=new FirefoxDriver();
	driver.get("https://www.cleartrip.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

@AfterClass
public void closeBrowser(){
	//driver.quit();
}


@BeforeMethod
public void setup(){
	//driver.manage().window().maximize();
}


@AfterMethod
public void setup1(){
//	driver.manage().window().setSize(new Dimension(500, 500));
}


@Test
public void searchFlight(){
	driver.findElement(By.xpath("//input[@name='origin']")).sendKeys("BLR");
	driver.findElement(By.xpath("//ul[contains(@id,'ui-id-1')]/li[1]")).click();
	driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("DEL");
	driver.findElement(By.xpath("//ul[contains(@id,'ui-id-2')]/li[1]")).click();
	driver.findElement(By.xpath("//div[@class='ctDatePicker']/div[1]/table/tbody/tr[4]/td[1]")).click();
	driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
	driver.findElement(By.xpath("//ul[@class='listView flights']/li[1]/table[1]/tbody[2]/tr[2]/td[3]/button")).click();
}

@Test
public void bookFlight(){
	

}


	
}
