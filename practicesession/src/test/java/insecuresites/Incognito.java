package insecuresites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Incognito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/lo");
		String s=driver.getTitle();
		System.out.println(s);
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//	        wait.until(ExpectedConditions.(revealed));
		driver.quit();

	}

}
