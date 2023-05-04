package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;


public class marathonsalesforce {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//login
		driver.findElement(By.xpath("(//div[@id='content']//input)[18]")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Thread.sleep(3000);

		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowlist= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowlist.get(1));
		driver.findElement(By.xpath("(//div[@class='dialog']//button)[2]")).click();
		
		//shadow root
		Shadow shadow =new Shadow(driver);
		WebElement learning = shadow.findElementByXPath("//span[text()='Learning']");
		learning.click();
		
		WebElement learningontrailhead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder=new Actions(driver); 
		builder.moveToElement(learningontrailhead).perform();
		
		WebElement salesforcecertification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		salesforcecertification.click();
		
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		String administrator = driver.findElement(By.xpath("//div[@class='certification-banner_title slds-container--medium slds-container--center slds-text-align--center']")).getText();
		
		if(administrator.equals("Administrator"))
		{
			System.out.println("Administrator certification page is displayed");
		}
		else
		{
			System.out.println("Administrator certification page is not displayed");
		}
		List<WebElement> certification = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		for(int i=0;i<certification.size();i++)
					{
			String certficationname = certification.get(i).getText();
			System.out.println("Certifications name :"+certficationname);
		}
		//screenshot of the certificate
		
		List<WebElement> screenshot = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
		for(int i=0;i<screenshot.size();i++)
		{
			Thread.sleep(2000);
			WebElement webElement = screenshot.get(i);
			//builder.moveToElement(webElement).click().perform();
			File screenshotAs = webElement.getScreenshotAs(OutputType.FILE);
			File dest=new File("./snaps/ADMCERIMG00"+i+".png");
			FileUtils.copyFile(screenshotAs,dest);
		}
		driver.quit();

		

		
	}

}
