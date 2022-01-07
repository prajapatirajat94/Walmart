package walmart.testlayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import walmart.basepackage.Walmartbasepackage;

public class Usertest extends Walmartbasepackage {

	
public Usertest() {
	super();
	
}
@BeforeMethod	
public void openbrowser() {
		initialize();
		driver.get(prop.getProperty("url1"));
	}
@Test
public void searchbox() throws InterruptedException {
Actions action = new Actions(driver);
	driver.findElement(By.xpath("//input[@class ='e1xoeh2i1 css-1c5nwkv eesbt950']")).sendKeys("apple")	;
	driver.findElement(By.xpath("//button[@class ='css-1v9c0kj e1xoeh2i2']")).click();
	Thread.sleep(10000);
	List<WebElement> lt = driver.findElements(By.xpath("//div[@id='product-results']//child::div[@class='css-1fnwt3w epettpn0']"));
	int sizer = lt.size();
	System.out.println(sizer);
}

	
}
