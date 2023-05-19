package week4.day1.HW;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws Exception {
		
		ChromeDriver driver=new ChromeDriver();
		List<String> tabledata=new ArrayList<String>();
		List<String> tablehead=new ArrayList<String>();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement table1 = driver.findElement(By.xpath("//div[@class='render']//table"));
		
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		int rowsize=rows.size();
		//System.out.println("No. of rows in the table is: "+(rowsize));
		Thread.sleep(8000);
		for(int i=0;i<1;i++)
		{
			WebElement columnelementhead = rows.get(i);
			List<WebElement> columnnamehead = columnelementhead.findElements(By.tagName("th"));
			for(int j=0;j<columnnamehead.size();j++)
			{
				WebElement columndatahead = columnnamehead.get(j);
				String text1 = columndatahead.getText();
				tablehead.add(text1);
			}
		}
		for(int i=1;i<rowsize-1;i++)
		{WebElement columnelement = rows.get(i);
		List<WebElement> columnname = columnelement.findElements(By.tagName("td"));
		for(int j=0;j<columnname.size();j++)
		{
			WebElement columndata = columnname.get(j);
			String text = columndata.getText();
			tabledata.add(text);
		}
		}
		//System.out.println("No of Columns in the table is: "+tabledata.size());
		System.out.println(tablehead);
		System.out.println(tabledata);
		for(int i=0;i<tablehead.size();i++)
		{
			System.out.print(tablehead.get(i)+"\t\t");
		}
		System.out.println();
		for(int i=0;i<tabledata.size();i++)
		{
			if(i==4)
			{
				System.out.println();
				System.out.print(tabledata.get(i)+"\t");
			}
			else
			{System.out.print(tabledata.get(i)+"\t");}
		}
}
}
