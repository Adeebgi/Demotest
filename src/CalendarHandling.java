import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("[class$='elementor-field-type-date elementor-field-group elementor-column elementor-field-group-travel_comp_date elementor-col-25'] [id='form-field-travel_comp_date']")).click();
		while(!driver.findElement(By.cssSelector("[class='flatpickr-current-month'] [class='cur-month']")).getText().contains("January")){
			{
				driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
			}
		}
		List<WebElement> date=driver.findElements(By.xpath("//span[@tabindex='-1']"));
		for(int i=0; i<driver.findElements(By.xpath("//span[@tabindex='-1']")).size();i++)
		{
		String text=driver.findElements(By.xpath("//span[@tabindex='-1']")).get(i).getText();
		if(text.equalsIgnoreCase("16"))
		{
			driver.findElements(By.xpath("//span[@tabindex='-1']")).get(i).clear();
			break;
		}
		}
	}
}


