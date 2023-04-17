package selenium.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShowMarathon {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//span[@class='sc-dBaXSw gYlrLO']")).click();
		String webtitle = driver.getTitle();
		System.out.println("Title of the current page is :: "+ webtitle);
		
		if(webtitle.contains("Hydrabad"))
		{
			System.out.println("City Hydrerabad has been selected ");

		}
		else
		{
			System.out.println("City Hydrabad Is not selected");
		}
		
		Thread.sleep(5000);

		
		//selecting the movie name DASARA
		driver.findElement(By.xpath("//span[text()='Search for Movies, Events, Plays, Sports and Activities']")).click();
		driver.findElement(By.xpath("//a[text()='Dasara (UA)']")).click();
		driver.findElement(By.xpath("//button[text()='Not Now']")).click();
		
		//print first theatre name
		WebElement firsttheatre = driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]"));
		String result= firsttheatre.getText();
		System.out.println("First theatre displayed is: "+ result);
		
		//parking facility avalaible
		driver.findElement(By.xpath("(//div[@class='info-section'])[1]")).click();
		WebElement pp = driver.findElement(By.xpath("//div[text()='            Parking Facility        ']"));
		boolean parkingdisplayed = pp.isDisplayed();
		if(parkingdisplayed==true)
		{
			System.out.println("Parking is available in this theatre");
		}
		else
		{
			System.out.println("Parking is not available in this theatre");
		}
		
		//close pop up
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		
		//Click First timiing green in the page
		driver.findElement(By.xpath("(//div[@class='showtime-pill-container _available'])[1]")).click();
driver.findElement(By.xpath("(//div[text()='Accept'])[1]")).click();
		
		Thread.sleep(3000);

		//select the seat count
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		driver.findElement(By.xpath("//div[@class='bar-btn _primary _full-width _centered']")).click();
		
		
		driver.findElement(By.xpath("//div[@id='B_5_025']")).click();
		driver.findElement(By.xpath("(//a[@class='bar-btn _primary'])[1]")).click();
		WebElement subtotal = driver.findElement(By.xpath("(//span[@id='subTT'])[1]"));
		Thread.sleep(3000);
		String finalsubtotal = subtotal.getText();
		System.out.println("Ticket value is "+finalsubtotal);
		 
	}

}

	


