package selenium.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDuplicateLead {

	
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
				
				//email click
				driver.findElement(By.linkText("Email")).click();
				
				//type in email id
				driver.findElement(By.id("ext-gen282")).sendKeys("vinayak@gmail.com");
				
				//find lead
				driver.findElement(By.id("ext-gen334")).click();
				Thread.sleep(5000);
				//select lead element  //print fist name of the lead                    
				WebElement name=driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[3]"));
				String firstname = name.getText();
				System.out.println(firstname);
				
				//click on the lead option
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();
				
				//click duplicate lead
				driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
				
				//url
				String title=driver.getTitle();

				if(title.contains("Duplicate Lead"))
				{
					
					//Create Lead in duplicate page
					driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
					//select the first name text in the page
					String dupfirstname=driver.findElement(By.id("viewLead_firstName_sp")).getText();
					
					System.out.println("Dup First name :"+dupfirstname);
					if(firstname.equals(dupfirstname))
					{
						System.out.println("Duplicate lead is created");
					}
					else
					{
						System.out.println("Duplicate lead is not created");
					}
				}
				else 
				{
					System.out.println("Duplicate page not displayed");	
				}
					
					
				}

				
								
				
				
				

	}




