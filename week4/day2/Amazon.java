package week4.day2.HW;

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

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.click();
		search.sendKeys("oneplus 9 pro");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
		
		String mrp = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		
		System.out.println("Price of the product is: "+ mrp);
		Thread.sleep(3000);

		String rating = driver.findElement(By.xpath("((//div[@class='a-row a-size-small'])//span)[1]")).getAttribute("aria-label");
		System.out.println("Rating of the product is: "+rating);

		driver.findElement(By.xpath("((//div[@class='a-section aok-relative s-image-fixed-height'])//img)[1]")).click();
		
		//windowopens
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wh=new ArrayList<String>(windowHandles);
		driver.switchTo().window(wh.get(1));
		
		//take screen shot in second page
		
		WebElement element = driver.findElement(By.id("imgTagWrapperId"));
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/IMGsnap002.png");
		FileUtils.copyFile(screenshotAs, dest);
		//FileUtils.copyFile(screenshotAs,dest);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(6000);
		
		String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("the sub total is: "+ subtotal);
		
		if(mrp.equals(subtotal))
		{
			System.out.println("The total is same");
		}
		else
		{
			System.out.println("The total is not same");
		}
		driver.quit();
	}

}
