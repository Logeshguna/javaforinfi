package sllider_new;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

public class NewSliders {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Slider.html");
		Actions act=new Actions(driver);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/a"));
		System.out.println(slider.getLocation());
		try{
		act.dragAndDropBy(slider, 239, 282).perform();
		System.out.println("insde try block");
		Thread.sleep(300);
		
		} catch(MoveTargetOutOfBoundsException e) {
			System.out.println(slider.getLocation());
			System.out.println("insde try block");
		} finally{
		driver.quit();
		}
	}
}
