package week4.day1.HW;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stock {

	public static void main(String[] args) {
		List<String> securitynames=new ArrayList<String>();
		Set<String> uniquesecuritynames=new LinkedHashSet<String>();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		//table seletion 
		WebElement table = driver.findElement(By.xpath("(//div[@class='table-responsive']//table)[1]"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			WebElement rowdata = rows.get(i);
			List<WebElement> eachrow = rowdata.findElements(By.tagName("td"));
			securitynames.add(eachrow.get(1).getText());
		}
		System.out.println(securitynames);
		uniquesecuritynames.addAll(securitynames);
		for(String each:uniquesecuritynames)
		{
			System.out.println(each);
		}
		
	}
}
