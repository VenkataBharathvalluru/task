package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task5bookingaticket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.id("src")).sendKeys("Hyd");
		driver.findElement(By.xpath("//*[@id=\"homeV2-root\"]/div[1]/div[2]/div/div[1]/div/div[1]/ul/li[2]/div/text[1]")).click();
		driver.findElement(By.id("dest")).sendKeys("ban");
		driver.findElement(By.xpath("//*[@id=\"homeV2-root\"]/div[1]/div[2]/div/div[3]/div[1]/ul/li[6]/div/text[1]")).click();
		
		
		String User_month = "Dec";

		String User_year = "2023";

		String User_date = "20";
		
		driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div/span")).click();
		
		while (true) {
			String Month_year =driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div")).getText();
			
			String[] MonyearSplit = Month_year.split(" ");

			String Month = MonyearSplit[0];
			String Year = MonyearSplit[1];

			if (Month.equals(User_month) && Year.equals(User_year)) {

				break;
			}
			else {
				driver.findElements(By.xpath(Year));
			}
		}
		


	}

}
