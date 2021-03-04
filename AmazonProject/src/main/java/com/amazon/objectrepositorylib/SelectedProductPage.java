package com.amazon.objectrepositorylib;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.WebDriverUtiles;

public class SelectedProductPage  extends WebDriverUtiles {
	WebDriver driver;
	public SelectedProductPage(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement adddcartbtn;
	
	

	public WebElement getadddcartbtn() {
		return adddcartbtn;
	}

}
