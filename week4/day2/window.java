package week4.day2.HW;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class window {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//to get the window Handle of current page
		String windowHandle = driver.getWindowHandle();
		System.out.println("The current page window handle" + windowHandle);
		System.out.println("CURRENT URL"+driver.getCurrentUrl());

		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		
		Set<String> windowHandle1 = driver.getWindowHandles();
		System.out.println(windowHandle1);
		System.out.println(driver.getCurrentUrl());
				
	}

}
