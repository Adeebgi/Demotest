package selenium;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class InvokingMultipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
	Set<String> Handles=driver.getWindowHandles();
	java.util.Iterator<String> it= Handles.iterator();
String ParentID=it.next();
		String ChildId=	it.next();
		driver.switchTo().window(ChildId);
		driver.get("https://rahulshettyacademy.com/");
	String CourseName=	driver.findElements(By.xpath("//div/h2/a")).get(0).getText();
	driver.switchTo().window(ParentID);
	WebElement name=driver.findElement(By.cssSelector("[name='name']"));
	name.sendKeys(CourseName);
	File file=name.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file,new File ("logo.png"));
	
System.out.println(name.getRect().getDimension().getHeight());
	System.out.println(name.getRect().getDimension().getWidth());
		
	}

}
