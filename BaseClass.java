package testcase;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	public ChromeDriver driver;
  
  @BeforeMethod
  public void preCondition() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

  }

  @AfterMethod
  public void postCondition() {
	  
	  driver.close();
  }

}
