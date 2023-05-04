package marathon2;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException, IOException{
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
		Shadow shadow=new Shadow(driver);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		
		WebElement learningontrailhead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions action=new Actions(driver);
		action.moveToElement(learningontrailhead).perform();
		
		
		WebElement salesforcecertification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		salesforcecertification.click();
		
		driver.findElement(By.xpath("(//a[@class='roleMenu_no-underline'])[2]")).click();
		
		
		List<WebElement> certification = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		for(int i=0;i<certification.size();i++)
		{
		String text = certification.get(i).getText();
		System.out.println("Certifications name : " + text);
		}
			driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
			
			List<WebElement> appcertification  = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
			for(int i= 0;i<appcertification.size();i++)
			{
				String text2 = appcertification.get(i).getText();
				System.out.println("Application Architect name : " + text2);
			}
			
			List<WebElement> screenshot = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
			for(int i=0;i<screenshot.size();i++)
			{
				Thread.sleep(2000);
				WebElement webElement = screenshot.get(i);
				
				//screenshot of each certificate in page
				File screenshotAs = webElement.getScreenshotAs(OutputType.FILE);
			File dest=new File("./snaps/ADMCERIMG00"+i+".png");
			FileUtils.copyFile(screenshotAs, dest);
			
				
			}
			driver.quit();
				
	}
		
}



