import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OpenConnectionMethods {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sayed Esmatullah\\Downloads\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
	List<WebElement> links=	driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	SoftAssert a = new SoftAssert();
	for(WebElement Link:links)
	{
		String url=Link.getAttribute("href");
		HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int ResponseCode=conn.getResponseCode();
		System.out.println(ResponseCode);
		
		a.assertTrue(ResponseCode<400, "The Link with The Text" + Link.getText()+"is the response of"+ResponseCode);
		
	}
		
		a.assertAll();

	}

}
