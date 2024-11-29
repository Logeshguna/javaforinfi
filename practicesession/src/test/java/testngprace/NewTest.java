package testngprace;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
  @Test
  public void openapp() {
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  
	  
  }
  @Test(priority=2)
  public void login() {
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	
  }
  @Test(priority=3)
  public void gettest() {
	  driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[6]/a")).click();
	  Assert.assertEquals("xyz", "xyz");
  }
  @Test(priority=4)
  public void logout() {
	  driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	  driver.quit();
  }
}
