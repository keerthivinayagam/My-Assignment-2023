package selenium.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTestpathHW4 {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		//login
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kumar.testleaf@gmail.com");
		
		//password
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("leaf@12");
		
		//login submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//url of resulting page
				String url= driver.getCurrentUrl();
				System.out.println(url);

				//logout
				driver.findElement(By.linkText("Log Out")).click();
				
				//close url
				driver.close();
		
		
		
		
	}

}



