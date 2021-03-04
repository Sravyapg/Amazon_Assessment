package com.amazon.genericlib;

	import java.sql.SQLException;
	import java.util.Iterator;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

	import com.amazon.objectrepositorylib.HomePage;
	
	/**
	 * Base class having all the common test steps required for every testscript
	 * @author Sravya
	 *
	 */
	public class BaseClass {
		public FileUtility flib=new FileUtility();
		public WebDriverUtiles wLib=new WebDriverUtiles();
		
		public ExcelUtility eLib = new ExcelUtility();	
	
		public WebDriver driver;
		
		@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
		public void configBS() {
			System.out.println("connect to database\n configure extent report");
		
		}
		@BeforeTest(groups = {"smokeTest" , "regressionTest"})
		public void configBT() {
			//used for cross browser execution
		}
		

		/**
		 * Launching the browser in normal mode and entering the url 
		 * @throws Throwable
		 */
		
		@BeforeClass(groups = {"smokeTest" , "regressionTest"})
		public void configBC() throws Throwable {
			String BROWSER = flib.getPropertyKeyValue("browser");
			if(BROWSER.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equalsIgnoreCase("ie")) {
				driver=new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			wLib.waitForHTMLDOM(driver);
			driver.get(flib.getPropertyKeyValue("url"));
		}
		
	
		
		/**
		 * close the browser
		 */
		@AfterClass(groups = {"smokeTest" , "regressionTest"})
		public void configAC() {
			driver.quit();
		}
		
		@AfterTest(groups = {"smokeTest" , "regressionTest"})
		public void configAT() {
			//close browser launched in cross browser testing
		}
		
		
		@AfterSuite(groups = {"smokeTest" , "regressionTest"})
		public void configAS() throws SQLException {
			
			System.out.println("close connection to database\n flush report");
			
		}
		
	}

