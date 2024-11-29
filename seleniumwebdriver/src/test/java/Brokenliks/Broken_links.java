package Brokenliks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Broken_links {

	public static void main(String[] args)  {	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\logesh.g\\Downloads\\geckodriver-v0.35.0-win-aarch64\\geckodriver.exe");)
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.deadlinkcity.com/");

	}

}
