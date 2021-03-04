package com.amazon.objectrepositorylib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.WebDriverUtiles;

public class ProductListPage extends WebDriverUtiles {
	WebDriver driver;
	public ProductListPage(WebDriver driver) {     
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private List<WebElement> prodlist;
	
	@FindBy(xpath = "(//span[contains(text(),'SYSKA T11')])[1]")
	private WebElement reqsingleprod;

	public List<WebElement> getprodlist() {
		return prodlist;
	}

	public WebElement getreqsingleprod() {
		return reqsingleprod;
	}

}
