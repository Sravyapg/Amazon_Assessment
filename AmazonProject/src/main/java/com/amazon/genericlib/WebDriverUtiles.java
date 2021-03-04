package com.amazon.genericlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * @author Sravya
 *
 */
public class WebDriverUtiles {
  
	
	/**
	 *  used to wait for Element to be clickable in GUI  & check for the elemnet for every 500 milisecond , 
	 * @param driver
	 * @param elemnet
	 */
	public void waitforElementToBeClickable(WebDriver driver , WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, IConstant.explicitlyWaitWiat);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * wait for DOM document to be load before finding any elemnet in GUI
	 * @param driver
	 */
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyWiat, TimeUnit.SECONDS);
		
	}
	
	/**
	 * used to wait for expected element in GUI
	 * @param element
	 * @throws Throwable
	 */
	public void waitforElement( WebElement element) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   element.isDisplayed();
			     break;
			   }catch (Throwable e) {
				Thread.sleep(500);
				count++;
			   }
	        }
	}
	
	/**
	 * used to wait for expected element in GUI based on Xpath
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebDriver driver , String xpath) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   driver.findElement(By.xpath(xpath)).click();
			     break;
			   }catch (Throwable e) {
				 Thread.sleep(500);
				 count++;
			   }
	        }
	}
	
	/**
	 * SWitch to Requried Window based on title Paremeter
	 * @param driver
	 * @param partailWindowTitle
	 */
	public void swicthToWindow(WebDriver driver , String partailWindowTitle) {
		  /*get all window session ID*/
		   Set<String> set = driver.getWindowHandles();
		   Iterator<String> it = set.iterator();
		    
		   while(it.hasNext()) {
			   String winID = it.next();
			   driver.switchTo().window(winID);
			   String actTitle = driver.getTitle();
			   if(actTitle.contains(partailWindowTitle)) {
				   System.out.println("swicthed to actual winow");
				   break;
			   }
		   }
	}
	
	
	
}
