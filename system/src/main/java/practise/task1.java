package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,15);
		
		
		WebElement alert=driver.findElement(By.id("alert"));
		alert.click();
		// wait.until(ExpectedConditions.elementToBeClickable(alert));
		Thread.sleep(5000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("populate-text")).click();
	    WebElement selnium=driver.findElement(By.id("h2"));
	    wait.until(ExpectedConditions.elementToBeClickable(selnium));
	    System.out.println(selnium.isDisplayed());
	    
	    driver.findElement(By.id("display-other-button")).click();
	    WebElement enable= driver.findElement(By.id("hidden"));
	    wait.until(ExpectedConditions.elementToBeClickable(enable));
	   System.out.println(enable.isDisplayed()); 
	   
	   driver.findElement(By.id("enable-button")).click();
	    WebElement button=driver.findElement(By.id("disable"));
	    wait.until(ExpectedConditions.elementToBeClickable(button));
	    System.out.println(button.isEnabled()); 
	    
	    driver.findElement(By.id("checkbox")).click();
	    WebElement checkbox=driver.findElement(By.id("ch"));
	    checkbox.click();
	    wait.until(ExpectedConditions.elementToBeClickable(checkbox));
	    System.out.println(checkbox.isSelected());
	    
	    driver.close();

	}

}
