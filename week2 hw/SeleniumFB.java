package selenium.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumFB {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//click new account
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		//create name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vinayagam");

		//create last lame
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("KV");
		
		//enter email.id
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Password");

		//create phoneno
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("959595");
		
			
		//selecting the date
		WebElement dd = driver.findElement(By.xpath("//select[@id='day']"));
		Select date=new Select(dd);
		date.selectByVisibleText("26");
		
		//selecting the month in date
		
		WebElement dm = driver.findElement(By.xpath("//select[@id='month']"));
		Select month =new Select(dm);
		month.selectByVisibleText("Aug");
		
		//select Year in date
		WebElement dy = driver.findElement(By.xpath("//select[@id='year']"));
		Select year=new Select(dy);
		year.selectByVisibleText("1995");
		
		//Gender radio button 
		
		driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
		
	}

}


