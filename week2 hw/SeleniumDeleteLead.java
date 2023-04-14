package selenium.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDeleteLead {
	
	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click lead
		driver.findElement(By.linkText("Leads")).click();
		
		//find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//phone click
		driver.findElement(By.linkText("Phone")).click();
		
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("959595");
		
		//find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//click resulting page
		WebElement data=driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"));
		//url of resulting page
		String url=data.getText();
		System.out.println(url);
		data.click();
		
		//delete lead
				driver.findElement(By.xpath("//a[text()='Delete']")).click();
				
				//find lead
				driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
				//Enter captured lead ID in Id Feild
				driver.findElement(By.xpath("//input[@name='id']")).sendKeys(url);
				//find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				// display deleted or not
				WebElement delete=driver.findElement(By.xpath("//div[text()='No records to display']"));
				String deleted= delete.getText();
				
				
				if(deleted.equals("No records to display"))
				{
					System.out.println("data "+url+" is deleted");
				}
				else 
				{
					System.out.println("data"+url +" is not deleted");
				}
				
				driver.close();


	}

}



