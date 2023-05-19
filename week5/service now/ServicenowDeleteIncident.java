package week5.day2.HW;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServicenowDeleteIncident extends Basesalesforce{

	@Test
	public void updateincident() throws InterruptedException
	{
		WebElement frame = shadow.findElementByXPath("//iframe[@title='Main Content']");
		//WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);
		List<WebElement> findElements = driver.findElements(By.xpath("//a[@class='linked formlink']"));
		int size = findElements.size();
		System.out.println(size);
		String text = findElements.get(size-1).getText();
		System.out.println("Incident going to be deleted is :"+text);
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		search.sendKeys(text);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(5000);
		//search.sendKeys(text);
		//search.sendKeys(Keys.ENTER);
		//Thread.sleep(5000);
		String norecord = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']")).getText();
		System.out.println("no record text is: "+norecord);
		if(norecord.equals("No records to display"))
		{
			System.out.println("Incident "+text +" is deleted");
		}
		else
		{
			System.out.println("Incident "+text +" is not deleted");
		}
		

	}

}
