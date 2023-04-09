package selenium.trial;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Seleniumhw1 {
	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		//select lead
		driver.findElement(By.linkText("Leads")).click();
		// to create lead
		driver.findElement(By.linkText("Create Lead")).click();

		
		//create company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("testleaf");
		// create first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("vinayak");
		//create last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("v");
		//enter the first name /local
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("yuva");
		//enter the department 
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("computer science");
		// enter the description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Always think positive");
		
		//enter email id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vinayak@gmail.com");
		
		//state province using drop down box
		WebElement drop = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select kk =new Select(drop);
		kk.selectByVisibleText("New York");
		
			
		//submit the buttom
		driver.findElement(By.name("submitButton")).click();
		
		//url of resulting page
		String url= driver.getCurrentUrl();
		System.out.println(url);
		
        //http://leaftaps.com/crmsfa/control/viewLead?partyId=13043
		
		
	}

}


	


