package seleniumwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Open_browser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame("frame1");
		WebElement b=driver.findElement(By.xpath("//body[text()='Parent frame']"));
		driver.switchTo().defaultContent();
		String s =b.getText();
		System.out.println(s);
		driver.close();

	}

}
