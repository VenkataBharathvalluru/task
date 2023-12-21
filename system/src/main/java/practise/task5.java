package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task5 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		WebElement location = driver.findElement(By.xpath("//div[@class='entry-content']"));
		Object loc=location.getLocation();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy"+loc);
		
		while(true) {
			
		String User_country = "India";
			
		WebElement countries =driver.findElement(By.xpath("//td[@style='width: 134.667px;']"));
		WebElement checks = driver.findElement(By.xpath("//input[@class='hasVisited']"));
		
		if(countries.equals(User_country)) {
			checks.click();
		}
		
		
		}
	}

}
