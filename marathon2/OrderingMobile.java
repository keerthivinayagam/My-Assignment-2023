package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class OrderingMobile {

		public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver(options);
			driver.get("https://dev136648.service-now.com/navpage.do");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("user_password")).sendKeys("Vinay456.");
			driver.findElement(By.id("sysverb_login")).click();
			
			Thread.sleep(10000);
			Shadow shadow=new Shadow(driver);
			shadow.findElementByXPath("//div[text()='All']").click();
			Thread.sleep(5000);
			
			WebElement servicecatlog = shadow.findElementByXPath("//label[text()='All filter navigator']/following-sibling::input");
			servicecatlog.sendKeys("Service catalog");
			Thread.sleep(1000);
			servicecatlog.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			
			WebElement frame=shadow.findElementByXPath("//iframe[@title='Main Content']");

			driver.switchTo().frame(frame);
			driver.findElement(By.xpath("(//td[@class='homepage_category_only_description_cell'])[8]//span/h2")).click();
			driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
			Thread.sleep(3000);
			
			//WebElement frame1=shadow.findElementByXPath("//iframe[@id='gsft_main']");
			//driver.switchTo().frame(frame1);
			driver.findElement(By.xpath("(//span[@class='input-group-radio']//label)[1]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
			
			driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")).click();
			driver.findElement(By.xpath("//option[@value='unlimited']")).click();
			
			driver.findElement(By.xpath("(//div[@class='sc-radio']/span)[7]")).click();
			//radio button
			driver.findElement(By.xpath("(//label[@class='radio-label'])[10]")).click();
			
			driver.findElement(By.xpath("(//div[@id='sc_cart_contents']//button)[1]")).click();
			String title = driver.getTitle();
			boolean contains = title.contains("Order Status");
			if(contains)
			{
				System.out.println("Order has been placed");
			}
			else
			{
				System.out.println("order has not been placed");
			}
			String requestnumber = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
			System.out.println("Request number for the order is: "+requestnumber);
			Thread.sleep(5000);

			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("./snaps/ORDIMG001.png");
			FileUtils.copyFile(screenshotAs,dest);
	
		}

	


	}


