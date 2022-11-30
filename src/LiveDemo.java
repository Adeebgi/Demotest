import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click on the column 
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all the Elements into a new original test. 
	List<WebElement> elements=driver.findElements(By.xpath("//tr/td[1]"));
	// capture text of all webelements into One new original List 
List<String>OriginalList=elements.stream().map(s->s.getText()).collect(Collectors.toList());
	List<String> sortedList=OriginalList.stream().sorted().collect(Collectors.toList());
	Assert.assertTrue(OriginalList.equals(sortedList));
List <String> Price;
	do
	{
		List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
	Price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getpriceviggea(s)).collect(Collectors.toList());
	Price.forEach(a->System.out.println(a));
	if(Price.size()<1)
	{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	}
	}while(Price.size()<1);
		
	}
 
	private static String getpriceviggea(WebElement s) {
	String Pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Pricevalue;
	}

}
