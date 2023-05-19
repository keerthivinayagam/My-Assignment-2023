package week4.day1.HW;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> tableheader=new ArrayList<String>();
		List<String> name=new ArrayList<String>();
		List<String> country=new ArrayList<String>();
		List<String> representative=new ArrayList<String>();
		List<String> joindate=new ArrayList<String>();
		List<String> status=new ArrayList<String>();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement tablehead = driver.findElement(By.xpath("(//table[@role='grid'])[1]"));
		
		List<WebElement> tableheadrow = tablehead.findElements(By.tagName("tr"));
		for(int i=0;i<tableheadrow.size();i++)
		{
			WebElement tableheadrowname = tableheadrow.get(i);
			List<WebElement> findElements = tableheadrowname.findElements(By.tagName("th"));
			for(int j=0;j<findElements.size();j++)
			{
				String head=findElements.get(j).getText();
				System.out.println(head);
				tableheader.add(head);
			}
		}
		//second column
		WebElement tablebody = driver.findElement(By.xpath("(//table[@role='grid'])[2]"));
		
		List<WebElement> tablebodyrow = tablebody.findElements(By.tagName("tr"));
		Thread.sleep(5000);
		for (int i=1;i<tablebodyrow.size();i++)
		{
			WebElement tablebodyname = tablebodyrow.get(i);
			List<WebElement> tablebodycolumn = tablebodyname.findElements(By.tagName("td"));
			//System.out.println(tablebodycolumn.size());
			name.add(tablebodycolumn.get(0).getText());
			country.add(tablebodycolumn.get(1).getText());
			representative.add(tablebodycolumn.get(2).getText());
			joindate.add(tablebodycolumn.get(3).getText());
			status.add(tablebodycolumn.get(4).getText());

		}
		for(int i=0;i<tableheader.size();i++)
		{
			System.out.print(tableheader.get(i)+"\t\t\t");
		}
		System.out.println();
		for(int j=0;j<name.size();j++)
		{
			System.out.print(name.get(j)+"\t\t");
			System.out.print(country.get(j)+"\t\t");
			System.out.print(representative.get(j)+"\t\t");
			System.out.print(joindate.get(j)+"\t\t");
			System.out.print(status.get(j)+"\t\t");
			System.out.println();
		}
	}
}

	

