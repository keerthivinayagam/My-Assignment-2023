package week5.day2.HW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.sukgu.Shadow;


public class Basesalesforce {
	
	public ChromeDriver driver;
	public Shadow shadow;
	@BeforeMethod
	public void login() throws InterruptedException
	{
		driver =new ChromeDriver();
		//driver.get("https://dev136648.service-now.com/navpage.do");
		driver.get("https://dev76433.service-now.com/navpage.do");
		//driver.get("//dev76433.service-now.com/navpage.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Vinay456.");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		Thread.sleep(10000);
		shadow=new Shadow(driver);
		shadow.findElementByXPath("//div[text()='All']").click();
		Thread.sleep(5000);
		
		WebElement servicecatlog = shadow.findElementByXPath("//label[text()='All filter navigator']/following-sibling::input");
		servicecatlog.sendKeys("incident");
		Thread.sleep(1000);
		servicecatlog.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
