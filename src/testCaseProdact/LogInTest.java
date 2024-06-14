package testCaseProdact;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LogInTest {
	
	WebDriver driver = new ChromeDriver();  
	String user = "standard_user"; 
	String password = "secret_sauce"; 
	String website = "https://www.saucedemo.com/"; 
	String login = "//input[@type='submit']";
	boolean expectedName = true ;
	boolean actualName ;
	boolean expactedPrice = true ; 
	String actualPrice;
	
	@Test (priority = 1 )
	public void setUpTest () { 
		driver.get(website);		
	    System.out.println(website.contains("en"));
	}

	@Test (priority = 2 )
	public void logINTest () { 
		driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath(login)).click();
			
		
	}

	@Test (priority = 3 )
	public void VireficationTheTextPradact() { 
		     WebElement theMianNameOnTheWebSite = driver.findElement(By.xpath("//span[@class='title']"));	      			
			 Assert.assertEquals(expectedName,theMianNameOnTheWebSite.isDisplayed());
	}
	
	@Test (priority = 4 )
	public void SortProdact () throws InterruptedException { 
		Thread.sleep(1000);
		WebElement selectOption = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselect = new Select(selectOption);
		myselect.selectByIndex(2);	
        	
	} 
	
	@Test (priority = 5)
	public void VerificationiLowPrice () throws InterruptedException { 
		        Thread.sleep(1000);		 
			    List<WebElement> listPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
			    String theLowestPriceAsTest = listPrices.get(0).getText().replace("$", "");
			    String theHighestPriceAsTest   = listPrices.get(listPrices.size()-1).getText().replace("$", "");
			    double lowestPrice = Double.parseDouble(theLowestPriceAsTest );
			    double highestPrice = Double.parseDouble(theHighestPriceAsTest );		
				Assert.assertEquals(lowestPrice < highestPrice , expactedPrice ,"the price first item is not low every all items ");
	        	
}
	
	
	
}
