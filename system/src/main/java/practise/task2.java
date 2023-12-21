package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String parentwindow = driver.getWindowHandle();  

		System.out.println("Parent window id is :" + parentwindow);

		driver.findElement(By.xpath("//span[text()='Help']")).click();

		Set<String> windows = driver.getWindowHandles();

		System.out.println(windows);

		for (String two_windows : windows) {

			if (!parentwindow.equals(two_windows)) {

				driver.switchTo().window(two_windows);

				driver.findElement(By.xpath("//i[@class='icon-close']")).click();
			}

		}

		driver.findElement(By.xpath("//a[text()='Help']")).click();

		Set<String> Three_windows = driver.getWindowHandles();

		System.out.println(Three_windows);

		List<String> multiple_windows = new ArrayList<String>(Three_windows);

		System.out.println("number of windows opeded " + multiple_windows.size());

		if (multiple_windows.size() <= 3) { // 0,1,2 ,3 ,4

			String last_window = multiple_windows.get(2);

			driver.switchTo().window(last_window);
			driver.findElement(By.xpath("//i[@class='icon-close']")).click();
			driver.quit();
		}

	}

}
