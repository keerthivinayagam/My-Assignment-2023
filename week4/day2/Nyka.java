package week4.day2.HW;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nyka {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.nykaa.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//Mouseover on Brands and Search L'Oreal Paris (ACTION)
			WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
			Actions builder=new Actions(driver);
			builder.moveToElement(brand).perform();
			
			driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
			Thread.sleep(3000);
			driver.findElement(By.xpath("((//div[text()='topbrands']/..//a))[1]")).click();
			System.out.println("Title of the current page"+ driver.getTitle());
			
			//sort By and select customer top rated
			driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
			driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
			
			
			driver.findElement(By.xpath("//span[text()='Category']")).click();
			driver.findElement(By.xpath("(//ul[@id='custom-scroll']//li)[2]")).click();
			driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
			driver.findElement(By.xpath("(//span[text()='Shampoo'])")).click();
			driver.findElement(By.xpath("(//span[text()='Concern'])")).click();
			driver.findElement(By.xpath("(//span[text()='Color Protection'])")).click();
			
			boolean shampoodisplayed = driver.findElement(By.xpath("//span[text()='Shampoo']")).isDisplayed();
			if(shampoodisplayed)
			{
				System.out.println("Shampoo filter is selected");
			}
			else
			{
				System.out.println("Shampoo filter is not selected");
			}
			
			WebElement shampooproduct  = driver.findElement(By.xpath("(//div[@class='css-ifdzs8']//div)[5]"));
			String productname = shampooproduct.getText();
			System.out.println("Product is: " + productname);
			shampooproduct.click();
			//product window
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowlist= new ArrayList<String>(windowHandles);
			driver.switchTo().window(windowlist.get(1));
			driver.findElement(By.xpath("(//div[@class='css-8lrug0']//select)")).click();
			Thread.sleep(1000);
			WebElement rr = driver.findElement(By.xpath("//option[@value='1']"));
			rr.click();
			System.out.println("The size of the Bottle "+ rr.getText());
			//MRP LISTING
			WebElement e = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']"));
			System.out.println("The MRP OF THE PRODUCT IS: " + e.getText());
			
			driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
			driver.findElement(By.xpath("//span[@class='cart-count']")).click();
			Thread.sleep(2000);
			
			//frame of the cart
			WebElement frame = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
			driver.switchTo().frame(frame);
			Thread.sleep(2000);
			
			//Grand total
			WebElement tot = driver.findElement(By.xpath("(//div[@class='css-15vhhhd e25lf6d1']//span)[1]"));
			System.out.println("The grand total of the product is : " + tot.getText());
			
			driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			
			//openGuest and close the adress tab
			driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
			driver.findElement(By.xpath("(//img[@alt='Image'])[7]")).click();
			Thread.sleep(1000);
			
			String grandtot = driver.findElement(By.xpath("(//div[@class='css-1qmsszm e1d2l6h73']//p)[5]")).getText();
			System.out.println("Grand total in the address page: "+grandtot);
			if(tot.equals(grandtot))
			{
				System.out.println("Both the total are same");
			}
			else 
			{
				System.out.println("Both the total are not same");
			}
			driver.quit();
			
	}

}
