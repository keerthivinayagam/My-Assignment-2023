package selenium.marathon;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BusMarathon {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//li[@select-id='results[0]'])[1]")).click();
		
		driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();

		
		//select next date
		driver.findElement(By.xpath("//td[text()='14']")).click();
		
		//search the bus
		
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		
		//get bus count number print count
		WebElement count = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']"));
		String NUM= count.getText();
		System.out.println(NUM);
		
		//sleeper Check BOX Select
		
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		
		
		//Click Bsy Nmae LISTED 2ND
		WebElement count1 = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]"));
		String text= count1.getText();
		System.out.println("Second bus in the result is "+text);
		
		//get title of second page
		String webtitle = driver.getTitle();
		System.out.println("Title of the current page is "+webtitle);

		
	
}

}


