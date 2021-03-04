package com.amazon.objectrepositorylib;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.WebDriverUtiles;

	
	/**
	 * 
	 * @author Sravya
	 *
	 */


	public class HomePage  extends WebDriverUtiles{
		WebDriver driver;
		public HomePage(WebDriver driver) {     
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
		private WebElement searchtextbox;
		
		@FindBy(xpath = "//input[@id='nav-search-submit-button']")
		private WebElement searchiconbtn;

		public WebElement getSearchtextbox() {
			return searchtextbox;
		}

		public WebElement getsearchiconbtn() {
			return searchiconbtn;
		}

}
