package selenium.marathon;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;

import java.time.Duration;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;


public class AmazzMarathon {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//select bag in search
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		driver.findElement(By.xpath("//span[text()=' for boys']")).click();
		//title of the page text 
		WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
		String totalsearchresult = result.getText();
		String[] split = totalsearchresult.split("");
		Thread.sleep(3000);
		System.out.println("Total results for bags for boys is "+split[3]);
		Thread.sleep(3000);
		//select 2 BRANDS IN Select
		driver.findElement(By.xpath("(//div[@id='p_89-title']/following-sibling::ul/li//span//a//span)[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@id='p_89-title']/following-sibling::ul/li//span//a//span)[6]")).click();
		//click featured to sort
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		//click newest arrival
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		//select 1st product name
		WebElement bag= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
		System.out.println("Name of the bag is: "+bag.getText());
		Thread.sleep(3000);
		
		//select 1 st product discounted amount
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		
		String discountedprice = price.getText();
		System.out.println("discounted price of the bag is: "+discountedprice);
		
		//close the browser
		driver.close();


}
}
