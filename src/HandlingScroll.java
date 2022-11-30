import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;

public class HandlingScroll {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	 js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	 List <WebElement> values =driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	 int sum=0;
		for(int i=0;i<values.size();i++)
		{
		sum = sum + Integer.parseInt(values.get(i).getText());
	
		}
	int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	Assert.assertEquals(sum, total);
		
	}

}