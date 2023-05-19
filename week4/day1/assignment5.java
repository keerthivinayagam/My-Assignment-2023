package week4.day1.HW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignment5 {

	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		
		//Drag and drop  by location
		WebElement drag = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		Point locationdrag = drag.getLocation();
		int dragx = locationdrag.getX();
		int dragy = locationdrag.getY();
		System.out.println(dragx+" "+dragy);
		builder.dragAndDropBy(drag,dragx+300,dragy+50).perform();
		
		//drag and drop in place
		
		WebElement dragpoint = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement droppoint = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		
		builder.dragAndDrop(dragpoint, droppoint).perform();
		
		//draggable columns
		WebElement dragcolumnsource = driver.findElement(By.xpath("(//span[text()='Category'])[1]"));
		WebElement dragcolumndest = driver.findElement(By.xpath("(//span[text()='Name'])[1]"));
		builder.dragAndDrop(dragcolumnsource, dragcolumndest).perform();
		
		//Thread.sleep(5000);

		//draggable rows
		WebElement dragrowsource = driver.findElement(By.xpath("(//tr[@data-ri='1'])[2]"));
		WebElement dragrowdest = driver.findElement(By.xpath("(//tr[@data-ri='2'])[2]"));
		builder.dragAndDrop(dragrowsource, dragrowdest).perform();
		
		//resizeimage
				Thread.sleep(5000);
				WebElement image = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
				builder.clickAndHold(image).moveByOffset(150,0).release().perform();
				
				
				//rangeslider
				WebElement sliderdefault = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
				builder.clickAndHold(sliderdefault).moveByOffset(100,0).perform();
				
				
				
				//Praogress bar
				String progresslevel = driver.findElement(By.xpath("//div[@class='ui-progressbar-label']")).getText();
				System.out.println("Before progress Start"+progresslevel);
				driver.findElement(By.xpath("//span[text()='Start']")).click();
				
								
				if(progresslevel.equals("100%"))
				{
					System.out.println("Current Progress is : "+progresslevel);
					System.out.println("Progress has been completed");
				}
				else 
				{
				Thread.sleep(2000);	
				progresslevel=driver.findElement(By.xpath("//div[@class='ui-progressbar-label']")).getText();
				System.out.println("Current Progress is"+progresslevel);
				if(progresslevel.equals("100%"))
				{
					System.out.println("Progress has been completed");
					
				}
				else {
					Thread.sleep(10000);
					progresslevel=driver.findElement(By.xpath("//div[@class='ui-progressbar-label']")).getText();
					System.out.println("Current Progress is"+progresslevel);
				if(progresslevel.equals("100%"))
				{
					System.out.println("Progress has been completed");
				}
				else
				{
					Thread.sleep(10000);
					progresslevel=driver.findElement(By.xpath("//div[@class='ui-progressbar-label']")).getText();
					System.out.println("Current Progress is"+progresslevel);
				}
				if(progresslevel.equals("100%"))
				{
					System.out.println("Progress has been completed");
				}
				}
				}
			}
		
}
