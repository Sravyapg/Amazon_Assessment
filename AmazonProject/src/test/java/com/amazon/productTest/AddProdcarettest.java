package com.amazon.productTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseClass;
import com.amazon.objectrepositorylib.CartPage;
import com.amazon.objectrepositorylib.CartselectPage;
import com.amazon.objectrepositorylib.HomePage;
import com.amazon.objectrepositorylib.ProductListPage;
import com.amazon.objectrepositorylib.SelectedProductPage;

public class AddProdcarettest extends BaseClass{

	@Test(groups = "RegressionTest")
	public void searchProductTestwithaddtocart() throws Throwable {

		//navigate to project link
		HomePage hp = new HomePage(driver);
		String prodname = flib.getPropertyKeyValue("prodname");
		String qty=flib.getPropertyKeyValue("qty");
		hp.getSearchtextbox().sendKeys(prodname);

		hp.getsearchiconbtn().click();


		ProductListPage p = new ProductListPage(driver);
		String product=p.getprodlist().get(0).getText();



		if(product.contains("SYSKA"))
		{
			System.out.println("verified in list");

		}






		p.getreqsingleprod().click();

		String parent=driver.getWindowHandle();
		Set<String> alltab = driver.getWindowHandles();
		Iterator<String> it = alltab.iterator();
		while(it.hasNext()) {
			String child_window=it.next();

			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);


				SelectedProductPage sp = new SelectedProductPage(driver);
				sp.getadddcartbtn().click();


				CartselectPage cs = new CartselectPage(driver);
				cs.getcartbtn().click();


				CartPage cp = new CartPage(driver);


				WebElement prod = driver.findElement(By.xpath("//span[contains(text(),'SYSKA')]"));
				if(prod.getText().contains(prodname))
				{
					System.out.println("verified in cart");

				}


				cp.getdropdown().click();
				cp.getqtyno().click();
				cp.getqtybox().sendKeys(qty);
				cp.getupdatebtn().click();
				String pricetext=cp.getpricevalue().getText();
				System.out.println(pricetext);


			}
		}
	}

}
