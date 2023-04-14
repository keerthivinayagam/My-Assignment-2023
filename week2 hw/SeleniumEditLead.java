package selenium.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEditLead {
	public static void main(String[] args) throws InterruptedException {
	{
		String updatecompanyname="Testleaf13";

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
				
				//finame NAME SEARCH
				
				driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("ram");
				//click lead 
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
				String page=driver.getTitle();
				System.out.println(page);
				
				if (page.equals("View Lead | opentaps CRM"))
				{
					System.out.println("View lead page is displayed");
					driver.findElement(By.xpath("//a[text()='Edit']")).click();
					WebElement companyname= driver.findElement(By.id("updateLeadForm_companyName"));
					companyname.clear();
					companyname.sendKeys(updatecompanyname);
					driver.findElement(By.xpath("//input[@value='Update']")).click();
					String updatedcompanyname=driver.findElement(By.id("viewLead_companyName_sp")).getText();
					System.out.println(updatedcompanyname);
					if(updatedcompanyname.contains(updatecompanyname))
					{
						System.out.println("Company name is updated");
					}
					else
					{
						System.out.println("Company name is not updated");
					}
				}
				else
				{
					System.out.println("View lead page is not displayed");
				}
			}
	}
}
				
				
		

	






