package week4.day2.HW;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//men selection and sports shoe using ACTIONS
		WebElement men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(4000);
		
		//count of the shoes
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("No of products:" + count);
		
		//training shoes
		driver.findElement(By.xpath("(//ul[@class='child-cat-wrapper  cat-wrapper']//div)[8]")).click();
		Thread.sleep(5000);

		
		//sort the data low to high
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(5000);
		
		//sort checking

		List<WebElement> shoeprice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	
		//8.Select the price range (900-1200) price is available only between 500 to 600 hence not done
		//System.out.println(driver.findElement(By.xpath("//input[@value='900']")).getText());
		//driver.findElement(By.xpath("//input[@value='900']")).sendKeys("900");
		//driver.findElement(By.xpath("//input[@value='1200']")).sendKeys("1200");
		//driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		
		//click navy blue
		driver.findElement(By.xpath("(//div[@class='filter-content ']//div)[5]")).click();
		//WebElement filter = driver.findElement(By.xpath("(//div[@class='navFiltersPill'])[1]"));
		//System.out.println("The filter appled are : "+ filter.getText());
		boolean selectednavy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).isSelected();
		boolean selectedfashion = driver.findElement(By.xpath("//div[text()='Training Shoes']")).isSelected();
		System.out.println(selectedfashion+""+selectednavy);
		if(selectedfashion && selectednavy)
		{
			System.out.println("All the filters are selected");
		}
		else
		{
			System.out.println("All the filters are not selected");
		}
		Thread.sleep(15000);
		
		//hover on the product
		WebElement shoeimage = driver.findElement(By.id("621868725223"));
		
		builder.moveToElement(shoeimage).perform();
		
		driver.findElement(By.xpath("//div[contains(text(), 'Quick View')]")).click();
		
				
		String actual = driver.findElement(By.xpath("(//div[@class='lfloat']//span)[1]")).getText();
		System.out.println("The original price :"+ actual);
		
		String disprice = driver.findElement(By.xpath("(//div[@class='lfloat']//span)[2]")).getText();
		System.out.println("The original price :"+ disprice);
		
		String dis = driver.findElement(By.xpath("(//div[@class='lfloat']//span)[3]")).getText();
		System.out.println("The original price :"+ dis);
		
		//snapshot
		WebElement element = driver.findElement(By.xpath("//img[@itemprop='image']"));
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/IMGsnap001.png");
		FileUtils.copyFile(screenshotAs,dest);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		
		
	}

}
