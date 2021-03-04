package com.amazon.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.WebDriverUtiles;

public class CartselectPage extends WebDriverUtiles {
	WebDriver driver;
	public CartselectPage(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
	private WebElement cartbtn;
	
	

	public WebElement getcartbtn() {
		return cartbtn;
	}

}
