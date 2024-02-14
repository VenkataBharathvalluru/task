package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("src")).sendKeys("hyderabad");
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div[1]/div/div[1]/ul/li[3]")).click();
		driver.findElement(By.id("dest")).sendKeys("bangalore");
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div[3]/div[1]/ul/li[4]/div/text[1]")).click();

	}

}
