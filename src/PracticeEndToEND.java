import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeEndToEND {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String adeeb="Option2";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click(); 
		WebElement Dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select Static= new Select(Dropdown);
		Static.selectByVisibleText("Option2");
	//System.out.println(Static.getFirstSelectedOption().getText());
	driver.findElement(By.cssSelector("input[id='name']")).sendKeys(adeeb);
	driver.findElement(By.id("alertbtn")).click();
	//driver.switchTo().alert().accept(); 
	//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
 String text=driver.switchTo().alert().getText();	
 if(text.contains(adeeb))
 {
	 System.out.println("Alert Message success");
 }
 else
	 System.out.println("Something goes wrong");
 {
	}  

}
}
