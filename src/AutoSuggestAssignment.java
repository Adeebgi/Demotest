import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("United");
		Thread.sleep(3000);
		List<WebElement> autosuggest=  driver.findElements(By.cssSelector("*[class='ui-menu-item']"));
		for(WebElement option:autosuggest)
		{
			if(option.getText().equalsIgnoreCase("United States (USA)")) {
				option.click();
				break; 
			}
		}
		
	}

}
