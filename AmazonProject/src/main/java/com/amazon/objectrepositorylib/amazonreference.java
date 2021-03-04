package com.amazon.objectrepositorylib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class amazonreference {


	@Test
	public void createProject() throws Throwable {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("SYSKA torch");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	List<WebElement> allphonelist = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for(int i=0;i<allphonelist.size();i++)
		{
			String text = allphonelist.get(i).getText();
			//System.out.println(text);
			if(text.contains("SYSKA torch"))
			{
				System.out.println("verified in list");
				
			}
			
		}
		
		driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
		String parent=driver.getWindowHandle();
		Set<String> alltab = driver.getWindowHandles();
		Iterator<String> it = alltab.iterator();
		while(it.hasNext()) {
			String child_window=it.next();

			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				
				
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']")).click();
				
				
				WebElement prod = driver.findElement(By.xpath("//span[contains(text(),'SYSKA')]"));
				if(prod.getText().contains("SYSKA torch"))
				{
					System.out.println("verified in cart");
					
				}
				
				driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
				driver.findElement(By.xpath("//a[.='10+']")).click();
				
				
				driver.findElement(By.xpath("//input[@name='quantityBox']")).sendKeys("10");
				
				driver.findElement(By.xpath("//a[contains(text(),'Update')]")).click();
				
				WebElement updatedprice = driver.findElement(By.xpath("//span[@class='currencyINR']"));
				System.out.println(updatedprice);
				
				
				
				
				
				
				
				
				
				
			
	}

}
	}
}
