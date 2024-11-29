package insecuresites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Insecuresss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		driver.get("https://expired.badssl.com/");
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//	        wait.until(ExpectedConditions.(revealed));
		driver.quit();

	}

}
