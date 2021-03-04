package com.amazon.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.WebDriverUtiles;

public class CartPage extends WebDriverUtiles{
	WebDriver driver;
	public CartPage(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(),'SYSKA')]")
	private WebElement cartprodname;
	
	@FindBy(xpath = "//span[@class='a-dropdown-label']")
	private WebElement dropdown;
	
	@FindBy(xpath = "//a[.='10+']")
	private WebElement qtyno;
	
	@FindBy(xpath = "//input[@name='quantityBox']")
	private WebElement qtybox;
	
	@FindBy(xpath = "//a[contains(text(),'Update')]")
	private WebElement updatebtn;
	
	@FindBy(xpath = "//span[@class='currencyINR']")
	private WebElement pricevalue;
	
	
	
	

	public WebElement getcartprodname() {
		return cartprodname;
	}
	public WebElement getdropdown() {
		return dropdown;
	}
	public WebElement getqtyno() {
		return qtyno;
	}
	

	public WebElement getqtybox() {
		return qtybox;
	}
	public WebElement getupdatebtn() {
		return updatebtn;
	}
	public WebElement getpricevalue() {
		return pricevalue;
	}

}
