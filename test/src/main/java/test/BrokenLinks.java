package test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   List<WebElement> links= driver.findElements(By.tagName("a"));
	   for(WebElement link:links) {
		   String url=link.getAttribute("href");
		   verifyLink(url);
		   
		   
	   }
	   
	}
	public static void verifyLink(String url) throws Throwable  {
		try {
			URL linkurl=new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) linkurl.openConnection();
			int code=httpConn.getResponseCode();
			if(code<200 || code>=400) {
				System.out.println("BrokenLinks "+ url +"Responsecode "+code);
			}else {
				System.out.println("validlinks "+ url +"Responsecode "+code);
			}
		} catch (Exception e) {
			System.out.println("Exception "+ e.getMessage());
			
		}
		
	}

}
	

