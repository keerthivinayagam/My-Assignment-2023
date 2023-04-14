package selenium.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumLeadHW1 {
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		// create contact
		driver.findElement(By.linkText("Create Contact")).click();
		
			
		// create first name
		driver.findElement(By.id("firstNameField")).sendKeys("ram");
		
		// create last name
		driver.findElement(By.id("lastNameField")).sendKeys("k");
		
		//name (LOCAL)
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("kumar");
		//last name 9LOCAL)
		driver.findElement(By.xpath("//input[@name='lastNameLocal']")).sendKeys("kv");
		
		//department
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("computer science");
		
		//describtion
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Think positivi in life");
		
		//email id
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("ram@gmail.com");
		
		//drop down box
		WebElement findElement = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select kk= new Select(findElement);
		kk.selectByVisibleText("New York");
		
		//submit the buttom
		
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		
		//edit button
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//edit description CLEAR
		
		WebElement findElement2 = driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']"));
		findElement2.clear();
		
		//important Note
		
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("Good LearnerOf Selenium");
		
		//update button
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//driver.findElement(By.name("submitButton")).click();
		
		//url of resulting page
		String url= driver.getCurrentUrl();
		System.out.println(url);
		
		
		}
	}



